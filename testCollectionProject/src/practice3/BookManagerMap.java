package practice3;

import java.util.*;

import practice2.*;

public class BookManagerMap {
	private HashMap booksMap;
	
	public BookManagerMap(){
		booksMap = new HashMap();
	}
	
	public BookManagerMap(HashMap booksMap){
		this.booksMap = new HashMap(booksMap);
	}
	
	public void putBook(Book book){
		booksMap.put(book.getbNo(), book);
	}
	
	public void removeBook(String key){
		booksMap.remove(key);
	}
	
	public String searchBook(String bTitle){
		/*String key = null;
		
		Set mset = booksMap.entrySet();
		Iterator booksIter = mset.iterator();
		
		while(booksIter.hasNext()){
			Map.Entry entry = (Map.Entry)booksIter.next();
			key = (String)entry.getKey();
			Book b = (Book)entry.getValue();
			count++;
			
			if(b.getTitle().equals(bTitle)==true) break;
		}
		if (mset.size() < count) return null;
		else return key;*/
		
	    String key = null;
	    List booksList = new ArrayList(booksMap.values());
		booksList.sort(new AscBookTitle());
	    for (int i=0; i<booksList.size(); i++){
	    	if (bTitle.equals(((Book)booksList.get(i)).getTitle())) {
	    		return ((Book)booksList.get(i)).getbNo();
	        }
	    }
	    return key;
	}
	
	public void displayAll(){
		Iterator keyIter = booksMap.keySet().iterator();
		while (keyIter.hasNext()){
			Object key = keyIter.next();
			System.out.println(booksMap.get(key));
		}
	}
	
	public Book[] sortedBookMap(){
		List booksList = new ArrayList(booksMap.values());
		booksList.sort(new AscBookTitle());
				
	     return (Book[]) booksList.toArray(new Book[0]);
		
		
		
	}
	
	public void printBookMap(Book[] br){
	      for (Book b : br) {
		         System.out.println(b);
	      }
	}
	
	public void printBook(String key){
		System.out.println(booksMap.get(key));
	}
	      
}
