<template>
  <div class="d-flex">
    <Sidebar />

    <div class="flex-grow-1 p-4">
      <!-- Aquí se renderiza el contenido privado -->
      <router-view />
    </div>
  </div>
</template>

<script setup>
import Sidebar from '@/components/Sidebar.vue'
</script>
