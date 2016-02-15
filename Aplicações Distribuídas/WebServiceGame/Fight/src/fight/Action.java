package fight;

public class Action {

    int status;

    int Attack() {
        status = 2;
        return 2;
    }

    int Defense() {
        status = 3;
        return 2;
    }

    int CounterAttack() {
        status = 4;
        return 2;
    }
}
