public class QuestionResponse {
    //   The unique identifier of the question response.
    public String id;
    //   The id of the question responded to.
    public String questionId; 
    //   Whether or not the response was marked as correct.
    public Boolean isCorrect; 

    public QuestionResponse(String id, String questionId, Boolean isCorrect) { 
        this.id = id; 
        this.questionId = questionId; 
        this.isCorrect = isCorrect; 
    }
    
}
