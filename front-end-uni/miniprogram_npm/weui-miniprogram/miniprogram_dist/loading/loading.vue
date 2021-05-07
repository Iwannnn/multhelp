<template>
<view :class="'wx_loading_view ' + (animated ? 'wx_loading_view__animated' : '') + ' ' + (!show ? 'wx_loading_view__hide' : '') + ' ' + extClass" :style="animated ? 'transition: height ' + duration + 'ms ease;' : ''" id="wx_loading_view">
    <view v-if="type==='dot-white'" class="loading wx_dot_loading wx_dot_loading_white">
    </view>
    <view v-else-if="type==='dot-gray'" class="loading wx_dot_loading"></view>
    <view v-else-if="type==='circle'" class="weui-loadmore">
        <view class="weui-loading"></view>
        <view class="weui-loadmore__tips">{{tips}}</view>
    </view>
</view>
</template>

<script>
module.exports =
/******/
(function (modules) {
  // webpackBootstrap

  /******/
  // The module cache

  /******/
  var installedModules = {};
  /******/

  /******/
  // The require function

  /******/

  function __webpack_require__(moduleId) {
    /******/

    /******/
    // Check if module is in cache

    /******/
    if (installedModules[moduleId]) {
      /******/
      return installedModules[moduleId].exports;
      /******/
    }
    /******/
    // Create a new module (and put it into the cache)

    /******/


    var module = installedModules[moduleId] = {
      /******/
      i: moduleId,

      /******/
      l: false,

      /******/
      exports: {}
      /******/

    };
    /******/

    /******/
    // Execute the module function

    /******/

    modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
    /******/

    /******/
    // Flag the module as loaded

    /******/

    module.l = true;
    /******/

    /******/
    // Return the exports of the module

    /******/

    return module.exports;
    /******/
  }
  /******/

  /******/

  /******/
  // expose the modules object (__webpack_modules__)

  /******/


  __webpack_require__.m = modules;
  /******/

  /******/
  // expose the module cache

  /******/

  __webpack_require__.c = installedModules;
  /******/

  /******/
  // define getter function for harmony exports

  /******/

  __webpack_require__.d = function (exports, name, getter) {
    /******/
    if (!__webpack_require__.o(exports, name)) {
      /******/
      Object.defineProperty(exports, name, {
        enumerable: true,
        get: getter
      });
      /******/
    }
    /******/

  };
  /******/

  /******/
  // define __esModule on exports

  /******/


  __webpack_require__.r = function (exports) {
    /******/
    if (typeof Symbol !== 'undefined' && Symbol.toStringTag) {
      /******/
      Object.defineProperty(exports, Symbol.toStringTag, {
        value: 'Module'
      });
      /******/
    }
    /******/


    Object.defineProperty(exports, '__esModule', {
      value: true
    });
    /******/
  };
  /******/

  /******/
  // create a fake namespace object

  /******/
  // mode & 1: value is a module id, require it

  /******/
  // mode & 2: merge all properties of value into the ns

  /******/
  // mode & 4: return value when already ns object

  /******/
  // mode & 8|1: behave like require

  /******/


  __webpack_require__.t = function (value, mode) {
    /******/
    if (mode & 1) value = __webpack_require__(value);
    /******/

    if (mode & 8) return value;
    /******/

    if (mode & 4 && typeof value === 'object' && value && value.__esModule) return value;
    /******/

    var ns = Object.create(null);
    /******/

    __webpack_require__.r(ns);
    /******/


    Object.defineProperty(ns, 'default', {
      enumerable: true,
      value: value
    });
    /******/

    if (mode & 2 && typeof value != 'string') for (var key in value) __webpack_require__.d(ns, key, function (key) {
      return value[key];
    }.bind(null, key));
    /******/

    return ns;
    /******/
  };
  /******/

  /******/
  // getDefaultExport function for compatibility with non-harmony modules

  /******/


  __webpack_require__.n = function (module) {
    /******/
    var getter = module && module.__esModule ?
    /******/
    function getDefault() {
      return module['default'];
    } :
    /******/
    function getModuleExports() {
      return module;
    };
    /******/

    __webpack_require__.d(getter, 'a', getter);
    /******/


    return getter;
    /******/
  };
  /******/

  /******/
  // Object.prototype.hasOwnProperty.call

  /******/


  __webpack_require__.o = function (object, property) {
    return Object.prototype.hasOwnProperty.call(object, property);
  };
  /******/

  /******/
  // __webpack_public_path__

  /******/


  __webpack_require__.p = "";
  /******/

  /******/

  /******/
  // Load entry module and return exports

  /******/

  return __webpack_require__(__webpack_require__.s = 14);
  /******/
})(
/************************************************************************/

/******/
{
  /***/
  14: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true
      },
      properties: {
        extClass: {
          type: String,
          value: ''
        },
        show: {
          // 默认显示出来
          type: Boolean,
          value: true
        },
        animated: {
          type: Boolean,
          value: false
        },
        duration: {
          // 过渡动画时间
          type: Number,
          value: 350
        },
        type: {
          type: String,
          value: 'dot-gray' // 取值dot-white、dot-gray、circle

        },
        tips: {
          // type是circle的时候才有效
          type: String,
          value: '加载中'
        }
      }
    });
    /***/
  })
  /******/

});

export default {
  data() {
    return {
      type: "",
      tips: "",
      animated: false,
      extClass: ""
    };
  },

  components: {},
  props: {},

  /******/
  i: moduleId,

  /******/
  l: false,

  /******/
  exports: {}
  /******/
  ,
  enumerable: true,
  get: getter,
  value: 'Module',
  value: true,
  enumerable: true,
  value: value,

  /***/
  14: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true
      },
      properties: {
        extClass: {
          type: String,
          value: ''
        },
        show: {
          // 默认显示出来
          type: Boolean,
          value: true
        },
        animated: {
          type: Boolean,
          value: false
        },
        duration: {
          // 过渡动画时间
          type: Number,
          value: 350
        },
        type: {
          type: String,
          value: 'dot-gray' // 取值dot-white、dot-gray、circle

        },
        tips: {
          // type是circle的时候才有效
          type: String,
          value: '加载中'
        }
      }
    });
    /***/
  })
  /******/
  ,
  methods: {}
};
</script>
<style>
.wx_loading_view{display:flex;justify-content:center;align-items:center;overflow:hidden}.wx_loading_view__hide{height:0 !important;display:none}.wx_loading_view__animated.wx_loading_view__hide{display:flex}.loading{color:rgba(255,255,255,0.9);font-size:17px;text-align:center}.loading_view_translation{transition:height .2s .3s ease}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwQXMwOWlTJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLGlCQUFpQixZQUFZLENBQUMsc0JBQXNCLENBQUMsa0JBQWtCLENBQUMsZUFBZSxDQUFDLHVCQUF1QixtQkFBbUIsQ0FBQyxZQUFZLENBQUMsaURBQWlELFlBQVksQ0FBQyxTQUFTLDJCQUEyQixDQUFDLGNBQWMsQ0FBQyxpQkFBaUIsQ0FBQywwQkFBMEIsOEJBQThCIiwiZmlsZSI6InRvLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi53eF9sb2FkaW5nX3ZpZXd7ZGlzcGxheTpmbGV4O2p1c3RpZnktY29udGVudDpjZW50ZXI7YWxpZ24taXRlbXM6Y2VudGVyO292ZXJmbG93OmhpZGRlbn0ud3hfbG9hZGluZ192aWV3X19oaWRle2hlaWdodDowICFpbXBvcnRhbnQ7ZGlzcGxheTpub25lfS53eF9sb2FkaW5nX3ZpZXdfX2FuaW1hdGVkLnd4X2xvYWRpbmdfdmlld19faGlkZXtkaXNwbGF5OmZsZXh9LmxvYWRpbmd7Y29sb3I6cmdiYSgyNTUsMjU1LDI1NSwwLjkpO2ZvbnQtc2l6ZToxN3B4O3RleHQtYWxpZ246Y2VudGVyfS5sb2FkaW5nX3ZpZXdfdHJhbnNsYXRpb257dHJhbnNpdGlvbjpoZWlnaHQgLjJzIC4zcyBlYXNlfSJdfQ== */
</style>