<template>
  <div class="filter">
      <label for="category">Category:</label>
      <select id="category" v-on:change="setCategoryFilter" v-model="selectedCategory">
          <option v-for="cat in $store.state.categories" v-bind:key="cat" v-bind:value="cat">{{ cat }}</option>
      </select>
  </div>
</template>

<script>
export default {
    name: 'filter-products',
    data() {
        return {
            selectedCategory: this.$store.state.category
        }
    },
    methods: {
        setCategoryFilter() {
            this.$store.commit('SET_CATEGORY', this.selectedCategory)
        }
    }
}
</script>

<style>

</style>