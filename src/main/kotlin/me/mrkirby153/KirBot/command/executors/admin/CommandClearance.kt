package me.mrkirby153.KirBot.command.executors.admin

import me.mrkirby153.KirBot.command.args.CommandContext
import me.mrkirby153.KirBot.command.executors.CmdExecutor
import me.mrkirby153.KirBot.utils.Context
import me.mrkirby153.KirBot.utils.getClearance

class CommandClearance : CmdExecutor() {

    override fun execute(context: Context, cmdContext: CommandContext) {
        context.send().info("Your rank is: `${context.author.getClearance(context.guild)}`").queue()
    }
}