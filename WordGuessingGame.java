public class WordGuessingGame {
    private String hiddenWord;
    private String guessedWord;
    private int numberOfTries;
    private InputReader reader;
    
    public WordGuessingGame() {
        this.hiddenWord = "abc";
        this.guessedWord = "___";
        this.numberOfTries = 0;
        this.reader = new InputReader();
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }
    
    public String getGuessedWord() {
        return guessedWord;
    }
    
    public void setGuessedWord(String guessedWord) {
        this.guessedWord = guessedWord;
    }
    
    public int getNumberOfTries(){
        return numberOfTries;
    }
    
    public void incrementNumberOfTries(){
        this.numberOfTries++;
    }
    
    public void showGuessedWord() {
        System.out.println("Palavra Adivinhada: " + guessedWord);
    }
    
    public void play() {
        showWelcome();
        
        while (!hiddenWord.equals(guessedWord)) {
            char letter = reader.getChar("Digite uma letra para tentar adivinhar a palavra:");
            guess(letter);
        }
        showResult();
    }
    
    private void showWelcome(){
        System.out.println("Bem-vindo ao jogo Adivinha a Palavra!");
        showGuessedWord();
    }
    
    private void guess(char letter){
        boolean found = false;
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == letter && guessedWord.charAt(i) == '_'){
                guessedWord = guessedWord.substring(0, i) + letter + guessedWord.substring(i + 1);
                found = true;
            }
        }
    
        if (!found) {
            System.out.println("Letra incorreta. Tenta novamente!");
            incrementNumberOfTries();
        }
        else{
            System.out.println("Letra Correta!");
        }
        showGuessedWord();
    }
    
    private void showResult(){
        System.out.println("Parabéns! Conseguiu adivinhar a palavra " + hiddenWord + " em " + getNumberOfTries() + " tentativas.");
    }
}