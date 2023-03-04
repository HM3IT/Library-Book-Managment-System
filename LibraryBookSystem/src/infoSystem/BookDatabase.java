package infoSystem;

public class BookDatabase {
	// implementing Singleton Class
	private static BookDatabase bookDataBase = null;
	private Book[] books;

	public static BookDatabase getInstance() {
		if (bookDataBase == null) {
			bookDataBase = new BookDatabase();
		}
		return bookDataBase;
	}

	private BookDatabase() {
		// initializing book data (illustration of getting book data from database)
		String[] isbnAry;
		String[] bookTitleAry;
		String[] bookCategoryAry;
		String[] authorAry;
		String[] publisherAry;
		String[] editionAry;

		isbnAry = new String[] { "9793161400001", "9793161400011", "9793161400021", "9793161400031", "9793161400041",
				"9793161400051", "9793161400061", "9793161400071", "9793161400081", "9793161400091", "9793161400101",
				"9793161400111", "9793161400121", "9793161400131", "9793161400141", "9793161400151", "9793161400161",
				"9793161400171", "9793161400181", "9793161400191", "9793161400201", "9793161400211", "9793161400221",
				"9793161400231", "9793161400241", "9793161400251", "9793161400261", "9793161400271", "9793161400281",
				"9793161400291", "9793161400301", "9793161400311", "9793161400321", "9793161400331", "9793161400341",
				"9793161400351", "9793161400361", "9793161400371", "9793161400381", "9793161400391", "9793161400401",
				"9793161400411", "9793161400421", "9793161400431", "9793161400441", "9793161400451", "9793161400461",
				"9793161400471", "9793161400481", "9793161400491", "9793161400501", "9793161400511", "9793161400521",
				"9793161400531", "9793161400541", "9793161400551", "9793161400561", "9793161400571", "9793161400581",
				"9793161400591", "9793161400601", "9793161400611", "9793161400621", "9793161400631", "9793161400641",
				"9793161400651", "9793161400661", "9793161400671", "9793161400681", "9793161400691", "9793161400701",
				"9793161400711", "9793161400721", "9793161400731", "9793161400741", "9793161400751", "9793161400761",
				"9793161400771", "9793161400781", "9793161400791", "9793161400801", "9793161400811", "9793161400821",
				"9793161400831", "9793161400841", "9793161400851", "9793161400861", "9793161400871", "9793161400881",
				"9793161400891", "9793161400901", "9793161400911", "9793161400921", "9793161400931", "9793161400941",
				"9793161400951", "9793161400961", "9793161400971", "9793161400981", "9793161400991" };

		bookTitleAry = new String[] { "Vahana Masterclass", "India’s 71-Year Test: The Journey to Triumph in Australia",
				"Right Under Our Nose", "Making of a General-A Himalayan Echo", "The Commonwealth of Cricket",
				"Manohar Parrikar-Off the Record", "The Little Book of Encouragement", "Beautiful Things’ A Memoir",
				"By Many a Happy Accident: Recollections of a Life", "Platform Scale: For A Post-Pandemic World",
				"Unfinished", "The Terrible, Horrible, Very Bad Good News", "ASOCA: A Sutra",
				"Maverick Messiah: A Political Biography of N T Rama Rao",
				"Rashtra Pratham - 82 Varshon ki Swarnim Gatha", "Stories I Must Tell: The Journey of an Actor",
				"Advantage India: The Story of Indian Tennis",
				"Dynasty to Democracy: The Untold Story of Smriti Irani’s Triumph", "Battle Ready for 21st Century",
				"My Experiments with Silence", "Names of the Women", "Suparipalana",
				"Manohar Parrikar: Brilliant Mind, Simple Life", "Odisha Itihaas",
				"The Braille edition of the book Exam Warriors", "Believe-What Life and Cricket Taught Me",
				"The Christmas Pig", "Whereabouts", "The Living Mountain: A Fable for Our Times",
				"Climate Change Explained—For One and All", "The Bench", "Elephant in the Womb",
				"Life in the Clock Tower Valley", "Sikkim: A History of Intrigue and Alliance",
				"Nehru, Tibet and China", "India and Asian Geopolitics: The Past, Present", "Sach Kahun Toh",
				"Stargazing: The Players in my Life", "Languages of Truth: Essays 2003-2020",
				"Savarkar: A Contested Legacy (1924-1966)",
				"Seven Lessons from Everest - Expedition Learnings from life and Business", "The Long Journey Home",
				"Home in the World", "The Nutmeg’s Curse: Parables for a Planet in Crisis",
				"Beyond Here and Other Poems", "The 7 Sins of Being a Mother", "Politics of Opportunism",
				"Malayalam poetry", "The Testaments", "Celestial Bodies", "Cheque book", "The Overstory",
				"The Braille edition of the book Exam Warriors", "Mind-Master", "Hemant Karkare: A Daughter’s Memoir",
				"Courts of India", "Hemant Karkare: A Daughter’s Memoir", "Braille Edition of Exam Warriors’",
				"Bridgital Nation", "Girl Power: Indian Women Who Broke The Rules", "Modern Medicine", "Fakir Hassen",
				"Turbulence and Triumph: The Modi Years", "Handbook on Fisheries Statistics - 2018",
				"Savarkar: Echoes from a forgotten past, 1883-1924", "Glorious Diaspora-Pride of India",
				"First They Erased Our Name: A Rohingya Speaks", "Obama: The Call of History",
				"Kashmir’s untold story: Declassification", "Sridevi: Girl Woman Superstar", "Manav",
				"The Commonwealth at 70: From Westminster to the World’", "Vivekadeepini",
				"Listening, Learning and Leading", "My Life, My Mission", "The New Delhi Conspiracy",
				"The Diary of Manu Gandhi’", "A Prime Minister to Remember", "Vivekadeepini",
				"Lessons Life Taught Me Unknowingly", "Cricket World Cup: The Indian Challenge”", "My Journey",
				"Making of New India", "Whispers of Time", "Indian Fiscal Federalism",
				"Chequered Brillance: The Many Lives of V K Krishna Menon’", "Designing Destiny: The Heartfulness Way’",
				"The Heartfulness way", "Darkness to light", "Fire and Fury Corps",
				"A Silent Revolution in the Offing in Indian Higher Education", "We are Displaced", "Saffron Swords’",
				"The New Delhi Conspiracy", "Diabetes with Delight", "The Last White Hunter",
				"Indian Cultures as Heritage", "Making of Legend", "Songs of a Coward", "An unsuitable boy", };

		bookCategoryAry = new String[] { "Action and adventure", "Art", "Business", "Classic", "Comic book", "Diary",
				"Crime", "Drama", "Guide", "Fairy tale", "Health & fitness", "Fantasy", "Historical fiction", "Humor",
				"Horror", "Journal", "Mystery", "Philosophy", "Poetry", "Romance", "Science fiction", "Review",
				"Science", "Sports and leisure", "Travel" };

		authorAry = new String[] { "Alfredo Covelli", "R. Kaushik", "R. Giridharan", "Lt. Gen. Konsam Himalay Singh",
				"Ramachandra Guha", "Waman Subha Prabhu", "Dalai Lama", "Hunter Biden",
				"Former Vice President Mohammad Hamid Ansari", "Sangeet Paul Choudary", "Priyanka Chopra Jonas",
				"Meghna Pant", "Irwin Allan Sealy", "Ramesh Kandula", "Amit Shah", "Kabir Bedi", "Anindya Dutta",
				"Anant Vijay", "Lt Gen AK Singh and Brig. Narendra Kumar", "Samir Soni", "Jeet Thayil",
				"Dr. Shailendra Joshi", "Nitin Gokhale", "Utkal Keshari Harekrushna Mahtab", "PM Narendra Modi",
				"Suresh Raina", "JK Rowling", "Jhumpa Lahiri", "Amitav Ghosh", "Aakash Ranison", "Meghan Markle",
				"Kalki Koechlin", "Shakoor Rather", "Preet Mohan Singh Malik", "Avtar Singh Bhasin",
				"Shivshankar Menon", "Neena Gupta", "Ravi Shastri", "Salman Rushdie", "Vikram Sampath", "Aditya Gupta",
				"Vinod Kapri", "Amartya Sen", "Amitav Ghosh", "Bishnupada Sethi", "Tahira Kashyap Khurrana" };

		publisherAry = new String[] { "Pearson", "Reed Elsevier", "ThomsonReuters", "Wolters Kluwer", "Random House",
				"Hachette Livre", "Grupo Planeta", "McGraw-Hill Education", "Holtzbrinck", "Scholastic (corp.)",
				"Cengage", "Wiley", "De Agostini Editore", "Shueisha", "Kodansha",
				"Springer Science and Business Media", "Houghton Mifflin Harcourt", "Shogakukan", "Harper Collins",
				"Informa", "Oxford University Press", "China Publishing Group Corporate",
				"Phoenix Publishing and Media Company", "Kadokawa Publishing", "Grupo Santillana", "Bonnier", "Gakken",
				"Egmont Group", "Simon & Schuster", "China Education and Media Group (form. Higher Education Press)" };

		editionAry = new String[] { "First", "Second", "Third", "Fourth" };

		int isbnAryLength = isbnAry.length;
		int categoryAryLength = bookCategoryAry.length;
		int authorAryLength = authorAry.length;
		int publisherAryLength = publisherAry.length;
		int editionAryLength = editionAry.length;

		books = new Book[isbnAryLength];

		for (int i = 0; i < isbnAryLength; i++) {

			String isbn = isbnAry[i];
			String title = bookTitleAry[i];
			String category = bookCategoryAry[i % categoryAryLength];
			String publisher = publisherAry[i % publisherAryLength];
			String author = authorAry[i % authorAryLength];
			String edition = editionAry[i % editionAryLength];

			books[i] = new Book(isbn, title, category, author, publisher, edition);
		}

	}

	public Book[] getBookAry() {
		return books;
	}
}
