import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '@/views/Products'
import ProductDetail from '@/views/ProductDetail'
import AddReview from '@/views/AddReview'
import NotFound from '@/views/NotFound'
import Store from '@/store/index'
import Watcher from '@/views/Watcher'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'products',
    component: Products
  },
  {
    path: '/products/:id',
    name: 'product-detail',
    component: ProductDetail
  },
  {
    path: '/products/:id/add-review',
    name: 'add-review',
    component: AddReview
  },
  {
    path: '/products',
    redirect: { name:'products' }
  },
  {
    path: '/watcher',
    name: 'watcher',
    component: Watcher
  },
  {
    // * matches everything else.  
    // The order is important, since the first routing rule found that matches
    // is used.  So this one must ALWAYS BE A THE LAST ONE.
    path: '*',
    name: 'not-found',
    component: NotFound
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

/*
  Navigation Guard
  Arguments: to - where the user is going
            from - where the user came from
            next - a function that sends the user to the next location
*/
router.beforeEach( (to, from , next) => {
  if (to.name === 'product-detail' || to.name === 'add-review') {
    const idFromPath = to.params.id;
    const product = Store.state.products.find( p => {
       return p.id == idFromPath;
    });
    if (!product) {
        // If the product was not found, send the user to the 404 page
        next( { name: 'not-found' } );
    }
  }

  // send the user to wherever they were trying to get to
  next();
})

export default router
