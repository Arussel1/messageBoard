package com.example.messageboard.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class MessageTest {

    @Test
    public void testMessageCreation() {
        // Arrange
        String messageText = "Hello, this is a test message!";
        String userName = "TestUser";
        Date dateAdded = new Date();

        // Act
        Message message = new Message(messageText, userName, dateAdded);

        // Assert
        assertEquals(messageText, message.getText());
        assertEquals(userName, message.getUserName());
        assertEquals(dateAdded, message.getAdded());
    }

    @Test
    public void testSettersAndGetters() {
        // Arrange
        Message message = new Message();
        String newText = "Updated message text";
        String newUserName = "UpdatedUser";
        Date newDate = new Date();

        // Act
        message.setText(newText);
        message.setUserName(newUserName);
        message.setAdded(newDate);

        // Assert
        assertEquals(newText, message.getText());
        assertEquals(newUserName, message.getUserName());
        assertEquals(newDate, message.getAdded());
    }

    @Test
    public void testIdSetterGetter() {
        // Arrange
        Message message = new Message();
        Long newId = 1L;

        // Act
        message.setId(newId);

        // Assert
        assertEquals(newId, message.getId());
    }
}
