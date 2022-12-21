import Vue from 'vue'
import Router from 'vue-router'
import MainScreen from './components/MainScreen'
import DetailsLivre from './components/LivreDetails'
import AddLivre from './components/AddLivre'
import ListeLivres from './components/ListeLivres'
import AuteurDetails from './components/AuteurDetails'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'mainScreen',
      component: MainScreen,
      props: true
    },
    {
      path: '/livres/:id',
      name: 'detailsLivre',
      component: DetailsLivre,
      props: true
    },
    {
      path: '/new',
      name: 'newLivre',
      component: AddLivre
    },
    {
      path: '/livres/:genre',
      name: 'livres',
      component: ListeLivres,
      props: true
    },
    {
      path: '/livres/update/:id',
      name: 'updateLivre',
      component: AddLivre,
      props: true
    },
    {
      path: '/auteurs/:id',
      name: 'auteurDetails',
      component: AuteurDetails,
      props: true
    }
  ]
})
