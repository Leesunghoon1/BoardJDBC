package boardJDBC;

public class BoardVO {

   private int bno;
   private String title; //제목
   private String writer; //작가
   private String content; //내용
   private String regdate; //시간
   private String moddate; //수정시간
   private int readcount; //카운트
   
   public BoardVO() {}

   //글쓰기용
   public BoardVO(String title, String writer, String content) {
      super();
      this.title = title;
      this.writer = writer;
      this.content = content;
   }

   //글수정용
   public BoardVO(int bno, String title, String writer, String content) {
      
      this.bno = bno;
      this.title = title;
      this.writer = writer;
      this.content = content;
   }

   //전체 리스트용
   public BoardVO(int bno, String title, String writer, String regdate, int readcount) {
      this.bno = bno;
      this.title = title;
      this.writer = writer;
      this.regdate = regdate;
      this.readcount = readcount;
   }

   //전체 상세 보기
   public BoardVO(int bno, String title, String writer, String content, String regdate, String moddate,
         int readcount) {
      super();
      this.bno = bno;
      this.title = title;
      this.writer = writer;
      this.content = content;
      this.regdate = regdate;
      this.moddate = moddate;
      this.readcount = readcount;
   }

   //상세 출력용
   public void printDetail() {
      System.out.println("글번호:"+bno+" writer : "+writer);
      System.out.println("제목:"+title+"("+readcount+")"+" 작성일 "+regdate);
      System.out.println("내용:"+content);
   }
   
   
   public int getBno() {
      return bno;
   }

   public void setBno(int bno) {
      this.bno = bno;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getWriter() {
      return writer;
   }

   public void setWriter(String writer) {
      this.writer = writer;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getRegdate() {
      return regdate;
   }

   public void setRegdate(String regdate) {
      this.regdate = regdate;
   }

   public String getModdate() {
      return moddate;
   }

   public void setModdate(String moddate) {
      this.moddate = moddate;
   }

   public int getReadcount() {
      return readcount;
   }

   public void setReadcount(int readcount) {
      this.readcount = readcount;
   }

   @Override
   public String toString() {
      return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", regdate="
            + regdate + ", readcount=" + readcount + "]";
   }
   
   
   
   
   
}