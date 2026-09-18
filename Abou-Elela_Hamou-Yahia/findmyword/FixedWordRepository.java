package findmyword;
public class FixedWordRepository extends WordRepository {

    private String value;

    public FixedWordRepository(String valueP) {
        this.value = valueP;
    }

    public Word getWord() {
        return new Word(this.value);
    }
}