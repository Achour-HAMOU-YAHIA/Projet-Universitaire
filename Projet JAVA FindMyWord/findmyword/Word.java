
package findmyword;
public class Word {

    private String value;

    public Word(String value) {
        this.value = value.toLowerCase();
    }

    public String getValue() {
        return this.value;
    }

    public boolean isValid() {
        if (this.value.length() != 5) {
            return false;
        }
        for (int i = 0; i < this.value.length(); i++) {
            char c = this.value.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        for (int i = 0; i < this.value.length(); i++) {
            for (int j = i + 1; j < this.value.length(); j++) {
                if (this.value.charAt(i) == this.value.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getLetterAt(int position) {
        return String.valueOf(this.value.charAt(position));
    }

    public boolean containsLetter(String c) {
        return this.value.contains(c);
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Word w = (Word) o;
        return this.value.equals(w.value);
    }

    public String toString() {
        return this.value;
    }
}