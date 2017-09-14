package me.mrkirby153.KirBot.music

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist
import com.sedmelluq.discord.lavaplayer.track.AudioTrack
import me.mrkirby153.KirBot.utils.Context
import me.mrkirby153.KirBot.utils.Time
import me.mrkirby153.KirBot.utils.embed.link
import me.mrkirby153.KirBot.utils.getMember
import net.dv8tion.jda.core.entities.User

class AudioTrackLoader(val manager: MusicManager, val requestedBy: User, val context: Context, val callback: ((AudioTrack) -> Unit)? = null) : AudioLoadResultHandler {
    override fun loadFailed(p0: FriendlyException?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun trackLoaded(p0: AudioTrack) {
        val queuedSong = MusicManager.QueuedSong(p0, requestedBy, context.channel.id)
        manager.queue.addLast(queuedSong)
        val position = manager.queue.indexOf(queuedSong)
        // Check track duration
        val settings = MusicManager.musicSettings[context.guild.id] ?: return
        if (settings.maxSongLength != -1)
            if (p0.duration / (60 * 1000) > settings.maxSongLength) {
                context.send().error("That song is too long. The max song length is ${Time.format(1,
                        (settings.maxSongLength * 60 * 1000).toLong(), Time.TimeUnit.FIT)}").queue()
                return
            }
        // If the bot isn't playing, start
        if (!context.guild.selfMember.voiceState.inVoiceChannel()) {
            manager.audioPlayer.volume = 100
            context.guild.audioManager.openAudioConnection(requestedBy.getMember(context.guild).voiceState.channel)
            manager.trackScheduler.playNextTrack()
        }
        manager.audioPlayer.isPaused = false
        if (manager.nowPlaying == null) {
            manager.trackScheduler.playNextTrack()
        }
        callback?.invoke(p0)
        if(manager.queue.size == 1 && manager.nowPlaying == null){
            return
        }
        context.send().embed("Added to Queue") {
            if(p0.info.uri.contains("youtu")){
                setThumbnail("https://i.ytimg.com/vi/${p0.info.identifier}/default.jpg")
            }
            setDescription("**${p0.info.title}**" link p0.info.uri)
            field("Song Duration", true, MusicManager.parseMS(p0.duration))

            var queueLengthMs: Long = 0
            manager.queue.forEach {
                queueLengthMs += it.track.duration
            }
            if (manager.nowPlaying != null)
                queueLengthMs -= manager.nowPlaying!!.position
            if (manager.nowPlaying == null)
                queueLengthMs = 0
            field("Author", true, p0.info.author)
            val playing = if (queueLengthMs < 1000) "NOW!" else MusicManager.parseMS(queueLengthMs)
            field("Time until playing", true, playing)
            field("Position in queue", true, position + 1)
        }.rest().queue()
    }

    override fun noMatches() {
        context.send().error("No matches were found for that song. Please try again").queue()
    }

    override fun playlistLoaded(p0: AudioPlaylist) {
        if (!MusicManager.musicSettings[context.guild.id]!!.playlists) {
            context.send().error("Playlists cannot currently be played").queue()
            return
        }
        // TODO 9/13/17: Playlist loading
    }
}