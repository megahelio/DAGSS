public class Book {
    private Author author;
    private String isbn;
    private String titulo;

    /**
     * @param author
     * @param isbn
     */
    public Book(Author author, String isbn, String titulo) {
        this.author = author;
        this.isbn = isbn;
        this.titulo = titulo;
    }

    public Book() {
        this.author = null;
        this.isbn = null;
        this.titulo = null;
    }
    
    /**
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }
    
    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }
    
    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
