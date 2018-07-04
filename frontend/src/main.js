import Vue from 'vue'
import Main from './Main.vue'
import VueMaterial from 'vue-material'
import ElementUI from 'element-ui';
import lang from 'element-ui/lib/locale/lang/en'
import locale from 'element-ui/lib/locale'
import 'vue-material/dist/vue-material.min.css'
import 'vue-material/dist/theme/default.css'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(VueMaterial)
Vue.use(ElementUI)
locale.use(lang)

new Vue({
  el: '#app',
  render: h => h(Main)
})
