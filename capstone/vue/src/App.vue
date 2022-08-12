<!--blanket nav to home|search|login/logout-->

<template>
  <div class="container is-fluid" id="app">
    <aside class="menu" id="nav">
      <p class="menu-label">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link></p>
      <p class="menu-label">
      <router-link v-bind:to="{ name: 'search' }">Search</router-link></p>
      <p class="menu-label">
      <router-link
        v-if="$store.state.token != null"
        v-bind:to="{ name: 'login' }"
        >Login</router-link
      >
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      ></p>
    </aside>
    <router-view />
  </div>
</template>
<style>

  </style>
