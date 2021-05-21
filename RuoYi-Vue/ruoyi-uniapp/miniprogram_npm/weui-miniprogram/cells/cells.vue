<template>
<view :class="extClass + ' weui-cells__group ' + outerClass + ' ' + childClass">
    <view v-if="title" class="weui-cells__title">{{title}}</view>
    <view :class="'weui-cells weui-cells_after-title ' + (checkboxCount > 0 && checkboxIsMulti ? 'weui-cells_checkbox' : '')">
        <slot></slot>
    </view>
    <view v-if="footer" class="weui-cells__tips">{{footer}}</view>
    <slot name="footer" v-else></slot>
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

  return __webpack_require__(__webpack_require__.s = 8);
  /******/
})(
/************************************************************************/

/******/
{
  /***/
  8: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true,
        multipleSlots: true
      },
      properties: {
        title: {
          type: String,
          value: ''
        },
        extClass: {
          type: String,
          value: ''
        },
        footer: {
          type: String,
          value: ''
        }
      },
      data: {
        firstItem: null,
        checkboxCount: 0,
        checkboxIsMulti: false,
        outerClass: '',
        childClass: ''
      },
      relations: {
        '../cell/cell': {
          type: 'descendant',

          linked(target) {
            if (!this.firstItem) {
              this.firstItem = target;
            }

            if (target !== this.firstItem) {
              target.setOuterClass('weui-cell_wxss');
            }
          }

        },
        '../form-page/form-page': {
          type: 'ancestor'
        },
        '../checkbox-group/checkbox-group': {
          type: 'descendant',

          linked(target) {
            this.setData({
              checkboxCount: this.checkboxCount + 1,
              checkboxIsMulti: target.data.multi
            });
          },

          unlinked(target) {
            this.setData({
              checkboxCount: this.checkboxCount - 1,
              checkboxIsMulti: target.data.multi
            });
          }

        }
      },
      methods: {
        setCellMulti(multi) {
          this.setData({
            checkboxIsMulti: multi
          });
        },

        setCellsClass(className) {
          this.setData({
            childClass: className
          });
        },

        setOuterClass(className) {
          this.setData({
            outerClass: className
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
      title: "",
      checkboxCount: 0,
      footer: "",
      childClass: "",
      outerClass: "",
      extClass: "",
      checkboxIsMulti: ""
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
  8: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true,
        multipleSlots: true
      },
      properties: {
        title: {
          type: String,
          value: ''
        },
        extClass: {
          type: String,
          value: ''
        },
        footer: {
          type: String,
          value: ''
        }
      },
      data: {
        firstItem: null,
        checkboxCount: 0,
        checkboxIsMulti: false,
        outerClass: '',
        childClass: ''
      },
      relations: {
        '../cell/cell': {
          type: 'descendant',

          linked(target) {
            if (!this.firstItem) {
              this.firstItem = target;
            }

            if (target !== this.firstItem) {
              target.setOuterClass('weui-cell_wxss');
            }
          }

        },
        '../form-page/form-page': {
          type: 'ancestor'
        },
        '../checkbox-group/checkbox-group': {
          type: 'descendant',

          linked(target) {
            this.setData({
              checkboxCount: this.checkboxCount + 1,
              checkboxIsMulti: target.data.multi
            });
          },

          unlinked(target) {
            this.setData({
              checkboxCount: this.checkboxCount - 1,
              checkboxIsMulti: target.data.multi
            });
          }

        }
      },
      methods: {
        setCellMulti(multi) {
          this.setData({
            checkboxIsMulti: multi
          });
        },

        setCellsClass(className) {
          this.setData({
            childClass: className
          });
        },

        setOuterClass(className) {
          this.setData({
            outerClass: className
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
.weui-cells__group_wxss.weui-cells__group_wxss .weui-cells__title{margin-top:24px}.weui-cells__group_form .weui-cells__tips{margin-top:8px;padding:0 32px;color:var(--weui-FG-1)}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwOHQxaDN0JTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLGtFQUFrRSxlQUFlLENBQUMsMENBQTBDLGNBQWMsQ0FBQyxjQUFjLENBQUMsc0JBQXNCIiwiZmlsZSI6InRvLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi53ZXVpLWNlbGxzX19ncm91cF93eHNzLndldWktY2VsbHNfX2dyb3VwX3d4c3MgLndldWktY2VsbHNfX3RpdGxle21hcmdpbi10b3A6MjRweH0ud2V1aS1jZWxsc19fZ3JvdXBfZm9ybSAud2V1aS1jZWxsc19fdGlwc3ttYXJnaW4tdG9wOjhweDtwYWRkaW5nOjAgMzJweDtjb2xvcjp2YXIoLS13ZXVpLUZHLTEpfSJdfQ== */
</style>