package com.airlisite.biz.entity;

import java.io.Serializable;

public class Books implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8202437908910310631L;
	private Integer id;
	private String title;
	private String author;
	private Integer publisherId;
	private String publishDate;
	private String isbn;
	private Integer wordsCount;
	private Double unitPrice;
	private String contentDescription;
	private String authorDescription;
	private String editorComment;
	private String toc;
	private Integer categoryId;
	private Integer clicks;
	private String pic;
	
	public Books(){
		
	}
	

	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + ", publisherId=" + publisherId
				+ ", publishDate=" + publishDate + ", isbn=" + isbn + ", wordsCount=" + wordsCount + ", unitPrice="
				+ unitPrice + ", contentDescription=" + contentDescription + ", authorDescription=" + authorDescription
				+ ", editorComment=" + editorComment + ", toc=" + toc + ", categoryId=" + categoryId + ", clicks="
				+ clicks + ", pic=" + pic + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Integer getPublisherId() {
		return publisherId;
	}


	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}


	public String getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Integer getWordsCount() {
		return wordsCount;
	}


	public void setWordsCount(Integer wordsCount) {
		this.wordsCount = wordsCount;
	}


	public Double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public String getContentDescription() {
		return contentDescription;
	}


	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}


	public String getAuthorDescription() {
		return authorDescription;
	}


	public void setAuthorDescription(String authorDescription) {
		this.authorDescription = authorDescription;
	}


	public String getEditorComment() {
		return editorComment;
	}


	public void setEditorComment(String editorComment) {
		this.editorComment = editorComment;
	}


	public String getToc() {
		return toc;
	}


	public void setToc(String toc) {
		this.toc = toc;
	}


	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public Integer getClicks() {
		return clicks;
	}


	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}


	public String getPic() {
		return pic;
	}


	public void setPic(String pic) {
		this.pic = pic;
	}
}
