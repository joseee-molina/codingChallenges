package chap7;

public class ChatServer {
    /**
     * Explain how you would design a chat server. What would be the hardest
     * problem to solve?
     *
     * First of all, you would log in with a username and a password, and after checking
     * those elements are correct in the hashmap maybe, then you would enter the server.
     *
     * There are an arry of users that you can contact, and for every user in your array of
     * friends there is actually more data like the conversations youve had with them, the
     * friends you have in common, and more data about the relationship between you and the
     * friends.
     *
     * There must be an inbox where you have incoming messages.
     *
     *
     *
     * There must be some methods that are relevant:
     * 1. sendMessageTO(Friend a, String message){} where you send the "message" to "a"
     * 2. openMEssage(Message m){} which will output the message m in the terminal.
     *
     */
}
