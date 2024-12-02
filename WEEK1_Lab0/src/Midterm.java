public class Midterm {
    private static final int MAX_MARK = 10;

    public static void main(String[] args) {
        int question;
        boolean pass;
        double fear;

        question = 3;
        fear = 7.3;
        pass = (question / MAX_MARK > 0 || (fear + MAX_MARK) < question + MAX_MARK % question);

        fear = question++ * fear;
        question += 13 / 3;
        System.out.println("Question: " + question);
        System.out.println("Pass: " + pass);
        System.out.println("Fear: " + fear);
    }
}
