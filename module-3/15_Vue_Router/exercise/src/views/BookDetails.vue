<template>
  <book-details />
</template>

<script>

import BookDetails from '@/components/BookDetails';

export default {
    components: {
        BookDetails
    },
    created() {
        const activeBook = this.$route.params.isbn;
        this.$store.commit('SET_ACTIVE_BOOK', activeBook);
    }
}
</script>

<style>

</style>