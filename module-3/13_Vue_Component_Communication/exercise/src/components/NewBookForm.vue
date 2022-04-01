<template>
<div>
    <h2>Add A New Book</h2>
    <form v-on:submit.prevent="addNewBook" class="new-book-form">
        <div class="title-input">
            <label for="title">Title: </label>
            <input type="text" name="title" v-model.trim="newBook.title">
        </div>
        <div class="author-input">
            <label for="author">Author: </label>
            <input type="text" name="author" v-model.trim="newBook.author">
        </div>
        <div class="isbn-input">
            <label for="isbn">ISBN: </label>
            <input type="text" name="isbn" v-model.trim="newBook.isbn">
        </div>
        <button type="submit" class="btn-save">Add New Book</button>
    </form>
</div>
  
</template>

<script>
export default {
    name: "new-book-form",
    data() {
        return {
            newBook: {
                title: "",
                author: "",
                read: false,
                isbn: ""
            }
        }
    },
    methods: {
        addNewBook() {
            this.$store.commit('ADD_NEW_BOOK', this.newBook)
        }
    }
}
</script>

<style>

</style>