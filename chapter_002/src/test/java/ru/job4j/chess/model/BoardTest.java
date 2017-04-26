package ru.job4j.chess.model;

import org.junit.Test;
import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * This class tests all figures of the chess.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 24.04.2017
 */
public class BoardTest {

    /**
     * method tests figure.
     */
    @Test
    public void whenElephantMoveFromOneOneToFiveFiveThenTrue() {

        Board board = new Board();

        Cell source = new Cell(1, 1);
        Cell destination = new Cell(5, 5);

        Figure elephant = new Bishop(source, Fraction.white);

        board.setFigure(elephant);

        boolean flag;

        flag = move(source, destination, board);

        assertTrue(flag);

        Figure actualFigure = board.getFigure(source);

        assertThat(actualFigure, is((Figure) null));

        actualFigure = board.getFigure(destination);

        assertTrue(actualFigure.getClass() == Bishop.class);

    }

    /**
     * method tests figure.
     */
    @Test
    public void whenElephantMoveFromFiveFiveToOneOneThenTrue() {

        Board board = new Board();

        Cell source = new Cell(5, 5);
        Cell destination = new Cell(1, 1);

        Figure elephant = new Bishop(source, Fraction.white);

        board.setFigure(elephant);

        boolean flag;

        flag = move(source, destination, board);

        assertTrue(flag);

        Figure actualFigure = board.getFigure(source);

        assertThat(actualFigure, is((Figure) null));

        actualFigure = board.getFigure(destination);

        assertTrue(actualFigure.getClass() == Bishop.class);

    }

    /**
     * method tests figure.
     */
    @Test
    public void whenElephantMoveFromFiveFiveToSevenThreeThenTrue() {

        Board board = new Board();

        Cell source = new Cell(5, 5);
        Cell destination = new Cell(7, 3);

        Figure elephant = new Bishop(source, Fraction.white);

        board.setFigure(elephant);

        boolean flag;

        flag = move(source, destination, board);

        assertTrue(flag);

        Figure actualFigure = board.getFigure(source);

        assertThat(actualFigure, is((Figure) null));

        actualFigure = board.getFigure(destination);

        assertTrue(actualFigure.getClass() == Bishop.class);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenElephantMoveFromFourFourToSevenThreeThenException() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(4, 4);
        Cell destination = new Cell(7, 3);

        Figure elephant = new Bishop(source, Fraction.white);

        board.setFigure(elephant);

        board.move(source, destination);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenBoardSourceCelHasNoFigureThenException() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell test = new Cell(1, 1);
        Cell source = new Cell(5, 5);
        Cell destination = new Cell(7, 3);

        Figure elephant = new Bishop(test, Fraction.white);

        board.setFigure(elephant);

        board.move(source, destination);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test(expected = OccupiedWayException.class)
    public void whenElephantHasFigureOnHisWayThenException() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(5, 5);
        Cell destination = new Cell(7, 3);

        Figure elephant = new Bishop(source, Fraction.white);
        Figure someFigure = new Bishop(new Cell(6, 4), Fraction.white);

        board.setFigure(elephant);
        board.setFigure(someFigure);

        board.move(source, destination);

    }

    /**
     * method tests figure.
     */
    @Test
    public void whenBishopMoveFromFiveFiveToSevenThreeWhereSetAnotherEnemyFigureThenTrue() {

        Board board = new Board();

        Cell source = new Cell(5, 5);
        Cell destination = new Cell(7, 3);

        Figure bishop = new Bishop(source, Fraction.white);
        Figure pawn = new Pawn(destination, Fraction.black);

        board.setFigure(bishop);
        board.setFigure(pawn);

        boolean flag;

        flag = move(source, destination, board);

        assertTrue(flag);

        Figure actualFigure = board.getFigure(source);

        assertThat(actualFigure, is((Figure) null));

        actualFigure = board.getFigure(destination);

        assertTrue(actualFigure.getClass() == Bishop.class);

    }

    /**
     * method tests figure.
     */
    @Test
    public void whenKingMoveFromFiveFiveToSixSixWhereSetAnotherEnemyFigureThenTrue() {

        Board board = new Board();

        Cell source = new Cell(5, 5);
        Cell destination = new Cell(6, 6);

        Figure king = new King(source, Fraction.white);
        Figure pawn = new Pawn(destination, Fraction.black);

        board.setFigure(king);
        board.setFigure(pawn);

        boolean flag;

        flag = move(source, destination, board);

        assertTrue(flag);

        Figure actualFigure = board.getFigure(source);

        assertThat(actualFigure, is((Figure) null));

        actualFigure = board.getFigure(destination);

        assertTrue(actualFigure.getClass() == King.class);

    }

    /**
     * method tests figure.
     */
    @Test
    public void whenKingMoveFromFiveFiveToSixFiveWhereSetAnotherEnemyFigureThenTrue() {

        Board board = new Board();

        Cell source = new Cell(5, 5);
        Cell destination = new Cell(6, 5);

        Figure king = new King(source, Fraction.white);
        Figure pawn = new Pawn(destination, Fraction.black);

        board.setFigure(king);
        board.setFigure(pawn);

        boolean flag;

        flag = move(source, destination, board);

        assertTrue(flag);

        Figure actualFigure = board.getFigure(source);

        assertThat(actualFigure, is((Figure) null));

        actualFigure = board.getFigure(destination);

        assertTrue(actualFigure.getClass() == King.class);

    }

    /**
     * method tests figure.
     */
    @Test
    public void whenKingMoveFromFiveFiveToFourFourWhereSetAnotherEnemyFigureThenTrue() {

        Board board = new Board();

        Cell source = new Cell(5, 5);
        Cell destination = new Cell(4, 4);

        Figure king = new King(source, Fraction.white);
        Figure pawn = new Pawn(destination, Fraction.black);

        board.setFigure(king);
        board.setFigure(pawn);

        boolean flag;

        flag = move(source, destination, board);

        assertTrue(flag);

        Figure actualFigure = board.getFigure(source);

        assertThat(actualFigure, is((Figure) null));

        actualFigure = board.getFigure(destination);

        assertTrue(actualFigure.getClass() == King.class);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenKingMoveFromFiveFiveToSevenSixWhereSetAnotherEnemyFigureThenTrue() throws ImpossibleMoveException, FigureNotFoundException, OccupiedWayException {

        Board board = new Board();

        Cell source = new Cell(5, 5);
        Cell destination = new Cell(7, 6);

        Figure king = new King(source, Fraction.white);

        board.setFigure(king);

        board.move(source, destination);


    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test (expected = FigureNotFoundException.class)
    public void whenHaveNoKingMoveFromFiveFiveThenException() throws ImpossibleMoveException, FigureNotFoundException, OccupiedWayException {

        Board board = new Board();

        Cell source = new Cell(5, 5);
        Cell destination = new Cell(6, 6);

        Figure king = new King(new Cell(4, 4), Fraction.white);

        board.setFigure(king);

        board.move(source, destination);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test (expected = OccupiedWayException.class)
    public void whenKingMoveFromFiveFiveToSixSixWhereStayPawnThenException() throws ImpossibleMoveException, FigureNotFoundException, OccupiedWayException {

        Board board = new Board();

        Cell source = new Cell(5, 5);
        Cell destination = new Cell(6, 6);

        Figure king = new King(source, Fraction.white);
        Figure pawn = new Pawn(destination, Fraction.white);

        board.setFigure(king);
        board.setFigure(pawn);

        board.move(source, destination);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test //Pawn black
    public void whenPawnBlackMoveFromOneZeroToTwoZeroThenTrue() throws ImpossibleMoveException, FigureNotFoundException, OccupiedWayException {

        Board board = new Board();

        Cell source = new Cell(1, 0);
        Cell dest = new Cell(2, 0);

        Figure pawn = new Pawn(source, Fraction.black);

        board.setFigure(pawn);

        boolean flag = board.move(source, dest);

        assertTrue(flag);

        assertThat(board.getFigure(source), is((Figure) null));
        assertTrue(board.getFigure(dest).getClass() == Pawn.class);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test //Pawn black
    public void whenPawnBlackMoveFromOneZeroToThreeZeroThenTrue() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(1, 0);
        Cell dest = new Cell(3, 0);

        Figure pawn = new Pawn(source, Fraction.black);

        board.setFigure(pawn);

        boolean flag = board.move(source, dest);

        assertTrue(flag);

        assertThat(board.getFigure(source), is((Figure) null));
        assertTrue(board.getFigure(dest).getClass() == Pawn.class);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test //Pawn white
    public void whenPawnWhiteMoveFromSixZeroToFiveZeroThenTrue() throws ImpossibleMoveException, FigureNotFoundException, OccupiedWayException {

        Board board = new Board();

        Cell source = new Cell(6, 0);
        Cell dest = new Cell(5, 0);

        Figure pawn = new Pawn(source, Fraction.white);

        board.setFigure(pawn);

        boolean flag = board.move(source, dest);

        assertTrue(flag);

        assertThat(board.getFigure(source), is((Figure) null));
        assertTrue(board.getFigure(dest).getClass() == Pawn.class);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test //Pawn white
    public void whenPawnWhiteMoveFromSixZeroToFourZeroThenTrue() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(6, 0);
        Cell dest = new Cell(4, 0);

        Figure pawn = new Pawn(source, Fraction.white);

        board.setFigure(pawn);

        boolean flag = board.move(source, dest);

        assertTrue(flag);

        assertThat(board.getFigure(source), is((Figure) null));
        assertTrue(board.getFigure(dest).getClass() == Pawn.class);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test (expected = ImpossibleMoveException.class) //Pawn exceptions
    public void whenPawnMoveFromSixZeroToThreeZeroThenException() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(6, 0);
        Cell dest = new Cell(3, 0);

        Figure pawn = new Pawn(source, Fraction.white);

        board.setFigure(pawn);

        board.move(source, dest);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test (expected = FigureNotFoundException.class) //Pawn exceptions
    public void whenHasNoPawnAtSourceCellThenException() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(6, 0);
        Cell dest = new Cell(4, 0);

        Figure pawn = new Pawn(new Cell(1, 1), Fraction.white);

        board.setFigure(pawn);

        board.move(source, dest);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test (expected = OccupiedWayException.class) //Pawn exceptions
    public void whenAnyFigureStayAtDestThenException() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(6, 0);
        Cell dest = new Cell(4, 0);

        Figure pawn = new Pawn(source, Fraction.white);
        Figure queen = new Queen(dest, Fraction.black);

        board.setFigure(pawn);
        board.setFigure(queen);

        board.move(source, dest);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    //Knight
    @Test
    public void whenKnightGoesHisWayThenTrue() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(4, 4);
        Cell dest = new Cell(6, 5);

        Figure knight = new Knight(source, Fraction.black);

        board.setFigure(knight);

        boolean flag = board.move(source, dest);

        assertTrue(flag);
        assertThat(board.getFigure(source), is((Figure) null));
        assertTrue(board.getFigure(dest).getClass() == Knight.class);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test
    public void whenKnightGoesHisAnotherWayThenTrue() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(4, 4);
        Cell dest = new Cell(5, 6);

        Figure knight = new Knight(source, Fraction.black);

        board.setFigure(knight);

        boolean flag = board.move(source, dest);

        assertTrue(flag);
        assertThat(board.getFigure(source), is((Figure) null));
        assertTrue(board.getFigure(dest).getClass() == Knight.class);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenKnightGoesWrongWayThenException() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(4, 4);
        Cell dest = new Cell(7, 2);

        Figure knight = new Knight(source, Fraction.black);

        board.setFigure(knight);

        board.move(source, dest);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    //Queen
    @Test
    public void whenQueenGoesRightWayThenTrue() throws ImpossibleMoveException, FigureNotFoundException, OccupiedWayException {

        Board board = new Board();

        Cell source = new Cell(0, 0);
        Cell stepOne = new Cell(7, 7);
        Cell stepTwo = new Cell(7, 0);
        Cell stepThree = new Cell(0, 7);

        Figure queen = new Queen(source, Fraction.black);

        boolean flag;

        board.setFigure(queen);

        board.move(source, stepOne);
        board.move(stepOne, stepTwo);
        flag = board.move(stepTwo, stepThree);

        assertTrue(flag);

        assertTrue(board.getFigure(stepThree).getClass() == Queen.class);
        assertThat(board.getFigure(stepTwo), is((Figure) null));
        assertThat(board.getFigure(stepOne), is((Figure) null));
        assertThat(board.getFigure(source), is((Figure) null));

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenQueenGoesWrongWayThenExcept() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(0, 0);
        Cell dest = new Cell(1, 3);

        Figure queen = new Queen(source, Fraction.black);

        board.setFigure(queen);

        board.move(source, dest);

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    //Rook
    @Test
    public void whenRookGoesRightWayThenTrue() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(0, 0);
        Cell stepOne = new Cell(0, 7);
        Cell stepTwo = new Cell(7, 7);

        Figure rook = new Rook(source, Fraction.black);

        board.setFigure(rook);

        board.move(source, stepOne);
        boolean flag = board.move(stepOne, stepTwo);

        assertTrue(flag);

        assertTrue(board.getFigure(stepTwo).getClass() == Rook.class);
        assertThat(board.getFigure(stepOne), is((Figure) null));
        assertThat(board.getFigure(source), is((Figure) null));

    }

    /**
     * method tests figure.
     *
     * @throws ImpossibleMoveException if this figure can not move from source to destination
     * @throws OccupiedWayException if there is figure on the way of this figure
     * @throws FigureNotFoundException if there is no figure on the source cell of the board
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenRookGoesWrongWayThenExcept() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Board board = new Board();

        Cell source = new Cell(0, 0);
        Cell dest = new Cell(1, 3);

        Figure rook = new Rook(source, Fraction.black);

        board.setFigure(rook);

        board.move(source, dest);

    }

    /**
     * method try move the figure and catch exceptions.
     *
     * @param source is source position of the figure
     * @param destination is the destination position of this figure
     * @param board is the board of chess
     * @return true if the figure move from source to destination
     */
    private boolean move(Cell source, Cell destination, Board board) {

        try {
            return board.move(source, destination);
        } catch (ImpossibleMoveException | OccupiedWayException | FigureNotFoundException e) {
            e.printStackTrace();
        }

        return false;

    }

}
