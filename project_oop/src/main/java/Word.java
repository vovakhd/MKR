import lombok.Getter;

@Getter
public final class Word {
    final private String word;
    final private String translate;

    public Word() { //передати назву файлу словника
        //завантаження з файлу словника
        this.word = "example";
        this.translate = "translate";
    }
}
