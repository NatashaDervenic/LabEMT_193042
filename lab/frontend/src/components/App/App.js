
import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Authors from "../Authors/authors";
import Categories from "../Categories/categories";
import Books from "../Books/BookList/books";
import Header from "../Header/header";
import BookShopService from "../../repository/bookShopRepository";
import Categories from "../Categories/categories";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: [],
            authors: [],
            selectedBook: {}
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Route path={"/authors"} exact render={() =>
                            <Authors authors={this.state.authors}/>}/>
                        <Route path={"/categories"} exact render={() =>
                            <Categories categories={this.state.categories}/>}/>
                        <Route path={"/books/add"} exact render={() =>
                            <ProductAdd categories={this.state.categories}
                                        authors={this.state.authors}
                                        onAddBook={this.addBook}/>}/>
                        <Route path={"/books/edit/:id"} exact render={() =>
                            <ProductEdit categories={this.state.categories}
                                         authors={this.state.authors}
                                         onEditBook={this.editBook}
                                         book={this.state.selectedBook}/>}/>
                        <Route path={"/books"} exact render={() =>
                            <Products books={this.state.books}
                                      onDelete={this.deleteBook}
                                      onEdit={this.getBook}/>}/>
                        <Route path={"/login"} exact render={() => <Login onLogin={this.fetchData}/>}/>
                        <Redirect to={"/books"}/>
                    </div>
                </main>
            </Router>


        );
    }

    componentDidMount() {
        this.fetchData()

    }

    fetchData = () => {
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors();
    }

    loadBooks = () => {
        BookShopService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    loadAuthors = () => {
        BookShopService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });

    }

    loadCategories = () => {
        BookShopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    deleteBook = (id) => {
        BookShopService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }
    addBook = (name, category, author, copies) => {
        BookShopService.addBook(name, category, author, copies)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        BookShopService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }

    editBook = (id, name, category, author, copies) => {
        BookShopService.editBook(id, name, category, author, copies)
            .then(() => {
                this.loadBooks();
            });
    }
            }

export default App;
