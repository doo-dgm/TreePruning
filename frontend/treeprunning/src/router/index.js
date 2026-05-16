import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import Administration from '../views/Administration.vue'
import PruningManagement from '../views/PruningManagement.vue'
import PQR from '../views/PQR.vue'
import Statistics from '../views/Statistics.vue'
import PublicLayout from '@/layouts/PublicLayout.vue'
import PrivateLayout from '@/layouts/PrivateLayout.vue'


const routes = [
  {
    path: '/',
    component: PrivateLayout,
    children: [

      { path: 'administracion', component: Administration },
      { path: 'podas', component: PruningManagement },
      { path: 'pqr', component: PQR },
      { path: 'estadisticas', component: Statistics },
    ],
    meta: { requiresAuth: false },
  },
  {
    path: '/login',
    component: PublicLayout,
    children: [
      { path: '', component: LoginView },
    ],
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
