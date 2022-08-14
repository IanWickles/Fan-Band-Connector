<!--blanket nav to home|search|login/logout-->

<template>
  <div id="app">
    <div id="titleBar">
      <img src="header.png"/>
    </div>
    <div id="nav" class="navbar is-pulled-right" :class="{ collapsed: navbarCollapsed }">
      <div class="collapse-bar" @click="toggleNavBar">
        <i class="fa-solid" :class="{ 'fa-caret-right': !navbarCollapsed, 'fa-caret-left': navbarCollapsed }"></i>
      </div>
      <ul>
        <li class="navbar-item"><router-link v-bind:to="{ name: 'home' }"><i class="fa-solid fa-house"></i> <div>Home</div></router-link></li>
        <li class="navbar-item"><router-link v-bind:to="{ name: 'bands' }"><i class="fa-solid fa-guitar"></i> <div>Bands</div></router-link></li>
        <li class="navbar-item"><router-link v-bind:to="{ name: 'venues' }"><i class="fa-solid fa-building"></i> <div>Venues</div></router-link></li>
        <li class="navbar-item" v-if="loggedIn"><router-link v-bind:to="{ name: 'profile' }"><i class="fa-solid fa-user"></i> <div>Profile</div></router-link></li>
        <li class="navbar-item" v-if="loggedIn"><router-link v-bind:to="{ name: 'logout' }"><i class="fa-solid fa-right-from-bracket"></i> <div>Logout</div></router-link></li>
        <li class="navbar-item" v-else><router-link v-bind:to="{ name: 'login' }"><i class="fa-solid fa-right-to-bracket"></i> <div>Login</div></router-link></li>
      </ul>
    </div>
    <div id="content">
      <router-view />
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        navbarCollapsed: false
      };
    },
    methods: {
      toggleNavBar() {
        this.navbarCollapsed = !this.navbarCollapsed;
      }
    },
    computed: {
      loggedIn() {
        return this.$store.state.token != '';
      }
    }
  }
</script>


<style>
  #nav {
    display: grid;
    grid-template-columns: auto 1fr;
    align-items: center;
  }
  .navbar.collapsed li div {
    display: none;
  }
  .navbar .navbar-item a {
    display: grid;
    grid-template-columns: auto 1fr;
    align-items: center;
  }
  .collapse-bar {
    cursor: pointer;
  }
  #titleBar {
    height: 150px;
    text-align: right;
  }
  #titleBar img {
    height: 95%;
  }
</style>
