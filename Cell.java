public class Cell{
  private int row;            //row of Cell
  private int col;            //column of Cell
  private int content;        //what is in the Cell(0:blank, 1-8:number, -1:mine)
  
  public Cell(){
  }
  
  public Cell(int r, int c){
    row=r;
    col=c;
  }
  
  public void setContent(int cont){
    content = cont;
  }
  
  public int getRow(){
    return row;
  }
  
  public int getCol(){
    return col;
  }
  
  public int getContent(){
    return content;
  }
}
  
  