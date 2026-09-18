
package findmyword;
import words.WordSet;
import words.JsonWordSet;

public class JsonWordRepository extends WordRepository {

    private WordSet wordSet;

    public JsonWordRepository(String jsonFilePath) throws Exception {
        this.wordSet = new JsonWordSet(jsonFilePath);
    }

    public Word getWord() {
        return new Word(this.wordSet.random());
    }
}