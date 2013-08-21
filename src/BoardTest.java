import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    public Board test_board = new Board();

    @Test
    public void testBoardSetup(){
        assertEquals(test_board.getSpace(0,0).getType(), "triple_word");
        assertEquals(test_board.getSpace(7,7).getType(), "double_word");
        assertEquals(test_board.getSpace(0,1).getType(), "normal");
        assertEquals(test_board.getSpace(14,3).getType(), "double_letter");
    }

}
