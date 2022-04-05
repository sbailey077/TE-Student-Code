<template>
<div class="card" v-bind:class="{ read: book.read }">
    <h2 class="book-title">{{ book.title }}</h2>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <h3 class="book-author">{{ book.author }}</h3>
    <p v-if="book.read">I have read this book</p>
    <p v-else>I have not read this book</p>
    <book-card />
</div>
</template>

<script>

import BookCard from '@/components/BookCard';

export default {
    name: 'book-details',
    components: {
        BookCard
    },
    computed: {
        book() {
            return this.$store.state.books.find(
                (b) => { return b.isbn == this.$store.state.activeBook}
            )
        }
    },
}
</script>

<style>

</style>