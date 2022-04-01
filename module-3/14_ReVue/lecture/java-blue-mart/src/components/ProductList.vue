<template>
    <div class="products">
        <p v-if="products.length === 0">No Products Found</p>
        <product-list-item v-else v-for="item in products" v-bind:key="item.id" v-bind:product="item" />
    </div>
</template>

<script>
import ProductListItem from '@/components/ProductListItem';

export default {
    name: 'product-list',
    components: {
        ProductListItem
    },
    computed: {
        products() {
           const products = this.$store.state.products;
           const category = this.$store.state.category;
           return products.filter( product => {
               return category === 'All' ? true : category === product.category;
           })
        }
    }

}
</script>

<style>
div.products {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
}
div.products p {
    font-size: 1.5rem;
}
</style>