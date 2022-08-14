package com.techelevator.dao;

import com.techelevator.model.Message;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMessageDao implements MessageDao {

        JdbcTemplate jdbcTemplate;

        public JdbcMessageDao(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }


    @Override
    public List<Message> getMessagesOfCurrentUser(int userId) {
        List<Message> messages = new ArrayList<>();
        String sql = "select * from messages \n" +
                "join band using (band_id) \n" +
                "join user_band using (band_id) \n" +
                "where user_id = " + userId + ";";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Message message = mapRowToMessage(results);
            messages.add(message);
        }
        return messages;
    }

    @Override
    public List<Message> sortMessagesByDate() {
        List<Message> messages = new ArrayList<>();
        String sql = "select message_id, message_body, message_timestamp, band_name  \n" +
                "from user_messages\n" +
                "join messages using(message_id)\n" +
                "join band using(band_id)\n" +
                "where user_id = 1\n" +
                "sort by message_timestamp;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Message message = mapRowToMessage(results);
            messages.add(message);
        }
        return messages;
    }

    @Override
    public List<Message> sortMessagesByBandName() {
        List<Message> messages = new ArrayList<>();
        String sql = "select message_id, message_body, message_timestamp, band_name  \n" +
                "from user_messages\n" +
                "join messages using(message_id)\n" +
                "join band using(band_id)\n" +
                "where user_id = 1\n" +
                "sort by band_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Message message = mapRowToMessage(results);
            messages.add(message);
        }
        return messages;
    }

    @Override
    public Boolean sendMessageToFollowers(Message newMessage, int MgrId) {
        String sql = "insert into messages(message_body, message_timestamp, band_id)\n" +
                "values ('?', CURRENT_TIMESTAMP, (select band_id from band where manager_id = ?))\n" +
                "returning message_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, newMessage.getMessageBody(), MgrId );
        int id = 0;
        if (results.next()) {
            id = newMessage.getMessageId();
            newMessage.setMessageId(id);
        }

        String sqlSecond = "INSERT INTO user_messages (user_id, message_id)\n" +
                "SELECT\n" +
                "\tuser_band.user_id,\n" +
                "\t(select message_id from messages where message_id = ?)\n" +
                "FROM user_band\n" +
                "WHERE user_band.band_id = (select band_id from band where manager_id = '?');";

        return jdbcTemplate.update(sqlSecond, id, MgrId ) == 1;

    }

    private Message mapRowToMessage (SqlRowSet rs) {
        Message message = new Message();

        message.setMessageId(rs.getInt("message_id"));
        message.setMessageBody(rs.getString("message_body"));
        message.setMessageTimestamp(rs.getDate("message_timestamp"));
        message.setBandId(rs.getInt("band_id"));

        return message;
    }
}
