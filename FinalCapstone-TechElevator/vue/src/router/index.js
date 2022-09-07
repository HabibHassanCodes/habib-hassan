import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Homepage from '../views/Homepage.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import BreweryInfo from '../components/BreweryInfo.vue'
import AllBrewery from '@/views/AllBrewery'
import AddBrewery from '@/views/AddBrewery'
Vue.use(Router)
/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",  //TODO make this the /
      name: "homepage",
      component: Homepage,
      meta: {
        requiresAuth: false
      }
    },
    // {
    //   path: '/', TODO
    //   name: 'home',
    //   component: Home,
    //   meta: {
    //     requiresAuth: true
    //   }
    // },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/brewery/name/:breweryName",
      name: "brewery-info",
      component: BreweryInfo,
      meta: {
        requiresAuth: false
      }
    },
    {
    path: "/allBeers",
    name: "all-beers",
    component: Home,
    meta: {
      requiresAuth: false
    }
   },
    {
      path: "/allBrewery",
      name: "all-breweries",
      component: Homepage,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/brewinfo",
      name: "all-brew-info",
      component: AllBrewery,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/addbrewery",
      name: "add-brewery",
      component: AddBrewery,
      meta: {
        requiresAuth: false
      }
    },
  ]
})
router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});
export default router;