<template>
<view :class="'weui-toptips ' + className + ' ' + extClass + ' ' + (show ? 'weui-toptips_show' :  '')">
    <block v-if="msg">{{msg}}</block>
    <block v-else>
        <slot></slot>
    </block>
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

  return __webpack_require__(__webpack_require__.s = 13);
  /******/
})(
/************************************************************************/

/******/
{
  /***/
  13: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true
      },
      properties: {
        type: {
          type: String,
          value: 'error',
          observer: '_typeChange'
        },
        show: {
          type: Boolean,
          value: false,
          observer: '_showChange'
        },
        msg: {
          type: String,
          value: ''
        },
        delay: {
          type: Number,
          value: 2000
        },
        extClass: {
          type: String,
          value: ''
        }
      },
      data: {
        typeClassMap: {
          warn: 'weui-toptips_warn',
          info: 'weui-toptips_info',
          success: 'weui-toptips_success',
          error: 'weui-toptips_error'
        }
      },

      attached() {
        const data = this;
        this.setData({
          className: data.typeClassMap[data.type] || ''
        });
      },

      methods: {
        _typeChange(newVal) {
          this.setData({
            className: this.typeClassMap[newVal] || ''
          });
          return newVal;
        },

        _showChange(newVal) {
          this._showToptips(newVal);
        },

        _showToptips(newVal) {
          if (newVal && this.delay) {
            setTimeout(() => {
              this.setData({
                show: false
              }, () => {
                // tooltips 隐藏了，触发 hide 事件
                this.$emit('hide', {
                  detail: {}
                }, {});
              });
            }, this.delay);
          }

          this.setData({
            show: newVal
          });
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
      msg: "",
      show: false,
      extClass: "",
      className: ""
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
  13: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true
      },
      properties: {
        type: {
          type: String,
          value: 'error',
          observer: '_typeChange'
        },
        show: {
          type: Boolean,
          value: false,
          observer: '_showChange'
        },
        msg: {
          type: String,
          value: ''
        },
        delay: {
          type: Number,
          value: 2000
        },
        extClass: {
          type: String,
          value: ''
        }
      },
      data: {
        typeClassMap: {
          warn: 'weui-toptips_warn',
          info: 'weui-toptips_info',
          success: 'weui-toptips_success',
          error: 'weui-toptips_error'
        }
      },

      attached() {
        const data = this;
        this.setData({
          className: data.typeClassMap[data.type] || ''
        });
      },

      methods: {
        _typeChange(newVal) {
          this.setData({
            className: this.typeClassMap[newVal] || ''
          });
          return newVal;
        },

        _showChange(newVal) {
          this._showToptips(newVal);
        },

        _showToptips(newVal) {
          if (newVal && this.delay) {
            setTimeout(() => {
              this.setData({
                show: false
              }, () => {
                // tooltips 隐藏了，触发 hide 事件
                this.$emit('hide', {
                  detail: {}
                }, {});
              });
            }, this.delay);
          }

          this.setData({
            show: newVal
          });
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
.weui-toptips_show.weui-toptips{display:block}.weui-toptips_show{-webkit-transform:translateZ(0) translateY(0);transform:translateZ(0) translateY(0);opacity:1}.weui-toptips_success{background-color:var(--weui-BRAND)}.weui-toptips_error{background-color:var(--weui-RED)}.weui-toptips_info{background-color:var(--weui-BLUE)}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwdFFDRVpMJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLGdDQUFnQyxhQUFhLENBQUMsbUJBQW1CLDZDQUE2QyxDQUFDLHFDQUFxQyxDQUFDLFNBQVMsQ0FBQyxzQkFBc0Isa0NBQWtDLENBQUMsb0JBQW9CLGdDQUFnQyxDQUFDLG1CQUFtQixpQ0FBaUMiLCJmaWxlIjoidG8uY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLndldWktdG9wdGlwc19zaG93LndldWktdG9wdGlwc3tkaXNwbGF5OmJsb2NrfS53ZXVpLXRvcHRpcHNfc2hvd3std2Via2l0LXRyYW5zZm9ybTp0cmFuc2xhdGVaKDApIHRyYW5zbGF0ZVkoMCk7dHJhbnNmb3JtOnRyYW5zbGF0ZVooMCkgdHJhbnNsYXRlWSgwKTtvcGFjaXR5OjF9LndldWktdG9wdGlwc19zdWNjZXNze2JhY2tncm91bmQtY29sb3I6dmFyKC0td2V1aS1CUkFORCl9LndldWktdG9wdGlwc19lcnJvcntiYWNrZ3JvdW5kLWNvbG9yOnZhcigtLXdldWktUkVEKX0ud2V1aS10b3B0aXBzX2luZm97YmFja2dyb3VuZC1jb2xvcjp2YXIoLS13ZXVpLUJMVUUpfSJdfQ== */
</style>