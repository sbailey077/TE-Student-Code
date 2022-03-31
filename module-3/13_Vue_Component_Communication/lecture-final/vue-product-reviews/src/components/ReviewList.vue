<template>
  <div class="reviews">
      <review-display 
        v-for="(review, index) in filteredReviews"
        v-bind:key="index"
        v-bind:review="review"
        />
  </div>
</template>

<script>
import ReviewDisplay from './ReviewDisplay';

export default {
    name: 'review-list',
    components: {
        ReviewDisplay
    },
    computed: {
        filteredReviews() {
            const reviewFilter = this.$store.state.filter;
            return this.$store.state.reviews.filter( review => {
                return reviewFilter === 0 ? true : reviewFilter === review.rating;
            });
        },
    }
}
</script>

<style>

</style>