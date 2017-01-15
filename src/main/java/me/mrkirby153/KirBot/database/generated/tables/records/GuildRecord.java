/*
 * This file is generated by jOOQ.
*/
package me.mrkirby153.KirBot.database.generated.tables.records;


import javax.annotation.Generated;

import me.mrkirby153.KirBot.database.generated.tables.Guild;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GuildRecord extends UpdatableRecordImpl<GuildRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = 93976199;

    /**
     * Setter for <code>kirbot.guild.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>kirbot.guild.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>kirbot.guild.guild_id</code>.
     */
    public void setGuildId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>kirbot.guild.guild_id</code>.
     */
    public String getGuildId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>kirbot.guild.command_prefix</code>.
     */
    public void setCommandPrefix(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>kirbot.guild.command_prefix</code>.
     */
    public String getCommandPrefix() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Guild.GUILD.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Guild.GUILD.GUILD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Guild.GUILD.COMMAND_PREFIX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getGuildId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getCommandPrefix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuildRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuildRecord value2(String value) {
        setGuildId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuildRecord value3(String value) {
        setCommandPrefix(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuildRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GuildRecord
     */
    public GuildRecord() {
        super(Guild.GUILD);
    }

    /**
     * Create a detached, initialised GuildRecord
     */
    public GuildRecord(Integer id, String guildId, String commandPrefix) {
        super(Guild.GUILD);

        set(0, id);
        set(1, guildId);
        set(2, commandPrefix);
    }
}
