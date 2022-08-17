public class Question {
    //   The unique identifier of the question.
    public String id; 
    //   The text of the question.
    public String text; 
    //   The correct answer of the question.
    public String answer; 

    public Question(String id, String text, String answer) { 
        this.id = id; 
        this.text = text; 
        this.answer = answer; 
    }    
}
