class Test{
    public static void main(String[] args){

        // create an instance of class PuzzleJava
        PazzleJava puzzleApp = new PazzleJava();
        puzzleApp.getTenRolls();

        puzzleApp.getRandomLetter();
        System.out.println(puzzleApp.generatePassword());
        System.out.println(puzzleApp.getNewPasswordSet(12));
    }
}