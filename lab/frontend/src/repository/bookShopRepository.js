import axios from '../custom-axios/axios';

const BookShopService = {
    fetchBooks: () => {
        return axios.get("/books");
    },

    fetchCategories: () => {
        return axios.get('/categories');
    },
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    deleteBook: (id) => {
        return axios.delete('/books/delete/${id}');
    },
    addBook: (name, category, availableCopies, author) => {
        return axios.post("/books/add", {
            "name": name,
            "category": category,
            "availableCopies": availableCopies,
            "author": author
        });
    },
    editBook: (id, name, category, availableCopies, author) => {
        return axios.put(`/products/edit/${id}`, {
            "name": name,
            "category": category,
            "availableCopies": availableCopies,
            "author": author
        });
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    },
    login: (username, password) => {
        return axios.post("/login", {
            "username": username,
            "password": password
        });
    },
}

export default BookShopService;
