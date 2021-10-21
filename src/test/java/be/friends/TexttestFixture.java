package be.friends;

public class TexttestFixture {
    public static void main(String[] args) {
        Friend[] friends = {
                new Friend("Angela", 0, 0, false, false),
                new Friend("AvadaKedabra", 0, 0, false, true),
                new Friend("Harry", 2, 29, false, true),
        };

        System.out.println("******* START");
        for (Friend f : friends) System.out.println(f);

        FriendshipUpdater app = new FriendshipUpdater(friends);
        app.update();

        System.out.println("******* AFTER UPDATE");
        for (Friend f : friends) System.out.println(f);

        System.out.println("******* DONE");
    }
}
