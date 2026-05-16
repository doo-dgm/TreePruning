<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

</script>

<template>
    <div class="bg-dark text-white p-3" style="width: 250px; height: 100vh;">
    <h5 class="mb-4">Mi App</h5>
    <ul class="nav flex-column">
      <li class="nav-item">
        <router-link class="nav-link text-white" to="/administration">Administracion</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link text-white" to="/pruning">Podas</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link text-white" to="/pqr">PQR</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link text-white" to="/statistics">Informes</router-link>
      </li>
    </ul>
  </div>

</template>

<style scoped>
.sidebar {
  width: 220px;
  background: #2c3e50;
  color: #fff;
  padding: 24px 0;
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.sidebar ul {
  list-style: none;
  padding: 0;
}
.sidebar li {
  padding: 16px 24px;
  cursor: pointer;
  transition: background 0.2s;
}
.sidebar li.logo {
  padding: 0 24px 24px 24px;
  text-align: center;
  cursor: default;
}
.sidebar li.logo img {
  width: 100px;
  height: 100px;
  object-fit: contain;
  border-radius: 10%;
  transition: transform 0.3s ease;
}
.sidebar li.logo img:hover {
  transform: scale(1.05);
}
.sidebar li:hover:not(.logo) {
  background: #34495e;
}
.sidebar li.active {
  background: #1abc9c;
  color: #fff;
  font-weight: bold;
}
.logout-btn {
  margin: 24px;
  padding: 12px 0;
  width: calc(100% - 48px);
  background: #b81f0e;
  color: #fff;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  font-weight: bold;
  transition: background 0.2s;
}
.logout-btn:hover {
  background: #e02c18;
}
</style>
