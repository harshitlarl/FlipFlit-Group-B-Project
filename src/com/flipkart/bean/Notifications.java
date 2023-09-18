package com.flipkart.bean;

/**
 * This class represents notifications in the GymFlipFit application.
 * It stores information about the notification's category, message, and notification ID.
 * Author: bhavya.khandelwal
 */
public class Notifications {

    private String category; // Category of the notification
    private String message; // Message content of the notification
    private int notificationId; // Unique identifier for the notification

    /**
     * Get the notification ID.
     * @author atulya.kumar
     * @return The notification ID.
     */
    public int getNotificationId() {
        return notificationId;
    }

    /**
     * Set the notification ID.
     * @author atulya.kumar
     * @param notificationId The notification ID to set.
     */
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Get the category of the notification.
     * @author harshit.soni
     * @return The category of the notification.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the category of the notification.
     * @author harshit.soni
     * @param category The category of the notification to set.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Get the message content of the notification.
     * @author harshit.soni
     * @return The message content of the notification.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the message content of the notification.
     * @author harshit.soni
     * @param message The message content of the notification to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
