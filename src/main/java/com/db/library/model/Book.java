package com.db.library.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="SM_Book")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Book() {
		super();
	
		// TODO Auto-generated constructor stub
	}
	public Book(String bookName,int topicid,Topic topic, Set<Author> authors) {
		super();
		this.name=bookName;
		this.topicid=topicid;
		//this.topic=topic;
		this.authors=authors;
		this.authorsString=getAuthorsString();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_id")
	private int id;
	
	@Column(name="book_name")
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getBookName() {
		return name;
	}
	public void setBookName(String bookName) {
		this.name = bookName;
	}
	
	
	
	  @ManyToOne 
	  @JoinColumn(name = "topic_id", insertable=false, updatable=false) private
	  Topic topic;
	  
	  public Topic getTopic() { return topic; }
	  
	  public void setTopic(Topic topic) { this.topic = topic; }
	 
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name="SM_Book_Author", joinColumns={@JoinColumn(referencedColumnName="book_id")}
    ,inverseJoinColumns={@JoinColumn(referencedColumnName="author_id")})  
     private Set<Author> authors;
	
	 @JsonManagedReference
	 public Set<Author> getAuthors() {
			return authors;
		}
	 public void setAuthors(Set<Author> authors) {
		 this.authors=authors;
		}
	 
    @Transient 
	public String authorsString;
	
	public String getAuthorsString() {
		String s="";
		if(authors.size()>0)
		{
		for(Author a:authors)
		{
			s+=","+ a.getFirstName()+" "+a.getLastName();
		}
        return s.substring(1);}
		return s;
    }	
	public void setAuthorsString() {
		String s="";
		if(authors.size()>0)
		{
		for(Author a:authors)
		{
			s+=","+ a.getFirstName()+" "+a.getLastName();
		}
		this.authorsString= s.substring(1);
		}
    }	
	
	@Column(name="topic_id")
	public int topicid;
	
	public int getTopicid() {
        return topicid;
    }
	public void setTopicid(int topicid) {
        this.topicid=topicid;
    }
	
	@Transient 
	public List<Integer> authorids;
	
	public List<Integer> getAuthorids() {
        return authorids;
    }
	public void setAuthorids(List<Integer> authorids) {
        this.authorids=authorids;
    }
	
	@Column(name="deleted")
	public int deleted;
	public void setDeleted(int i) {
		// TODO Auto-generated method stub
		deleted=1;
	}

}
