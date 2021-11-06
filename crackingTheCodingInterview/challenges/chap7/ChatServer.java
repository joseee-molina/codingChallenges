package chap7;

public class ChatServer {
    /**
     * Explain how you would design a chat server. What would be the hardest
     * problem to solve?
     *
     * Login and register:
     * First of all, you would log in with a username and a password, and after checking
     * those elements are correct in the hashmap maybe, then you would enter the server.
     *
     * If you don't have an account, you would create one user with an username, a password,
     * an email, etc.
     *
     * Friends
     *
     * There are an array of users that you can contact, and for every user in your array of
     * friends there is actually more data like the conversations you've had with them, the
     * friends you have in common, and more data about the relationship between you and the
     * friends.
     *
     * Inbox
     * There must be an inbox where you have incoming messages. Maybe it can be a hashmap
     *
     * There must be some methods for messaging:
     * 1. sendMessageToFriend(Friend a, String message){} where you send the "message" to "a"
     * 2. openMEssage(Message m){} which will output the message m in the terminal.
     * 3. reply(Message m, String reply){} where you reply to some message.
     *
     *
     *
     *
     *
     */
}
