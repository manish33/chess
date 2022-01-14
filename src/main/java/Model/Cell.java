package Model;

import Model.Pieces.Piece;

import java.util.Objects;

public class Cell {
    public Piece occuPipedBy;
    public int x;
    public int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell(Piece occuPipedBy, int x, int y) {
        this.occuPipedBy = occuPipedBy;
        this.x = x;
        this.y = y;
        if(occuPipedBy!=null){
            occuPipedBy.cell=this;
        }
    }

    public Cell[] upDiagonals(Board board){
        if(x+1<=board.cells.length-1 && y-1>=0 && y+1<=board.cells[0].length-1 && x-1 >=0){
            Cell leftUP=board.cells[this.x+1][this.y-1];
            Cell rightUP=board.cells[this.x+1][this.y+1];
            return new Cell[]{leftUP,rightUP};
        }
        return null;
    }

    public Cell[] downDiagonals(Board board){
        if(x+1<=board.cells.length-1 && y-1>=0 && y+1<=board.cells[0].length-1 && x-1 >=0) {
            Cell leftDown = board.cells[this.x - 1][this.y - 1];
            Cell rightDown = board.cells[this.x - 1][this.y + 1];
            return new Cell[]{leftDown, rightDown};
        }
        return null;
    }

    boolean isOccupied(){
        return occuPipedBy!=null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


}
