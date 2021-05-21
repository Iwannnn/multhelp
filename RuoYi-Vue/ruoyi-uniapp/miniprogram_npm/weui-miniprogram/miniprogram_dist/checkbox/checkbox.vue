<template>
<mp-cell :has-footer="!multi" :has-header="multi" @tap="checkedChange" :ext-class="'weui-check__label ' + outerClass + ' ' + extClass + ' ' + (!multi ? '^weui-cell_radio' : '^weui-cell_checkbox')" ext-hover-class="weui-active">

  <view slot="icon" v-if="multi">
    <checkbox :value="value" :checked="checked" :disabled="disabled" :color="color" class="weui-check">
    </checkbox>
    <!-- 未勾选 -->
    <icon class="weui-icon-checked"></icon>
  </view>
  <view>{{label}}</view>
  <view slot="footer" v-if="!multi">
    <radio :value="value" :checked="checked" :disabled="disabled" :color="color" class="weui-check"></radio>
    <!-- 已勾选 -->
    <icon class="weui-icon-checked"></icon>
  </view>
</mp-cell>
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

  return __webpack_require__(__webpack_require__.s = 25);
  /******/
})(
/************************************************************************/

/******/
{
  /***/
  25: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true,
        multipleSlots: true
      },
      properties: {
        multi: {
          type: Boolean,
          value: true
        },
        checked: {
          type: Boolean,
          value: false
        },
        value: {
          type: String,
          value: ''
        },
        label: {
          type: String,
          value: 'label'
        },
        extClass: {
          type: String,
          value: ''
        }
      },
      data: {},
      relations: {
        '../checkbox-group/checkbox-group': {
          type: 'ancestor',

          linked(target) {
            this.group = target;
          },

          unlinked() {
            this.group = null;
          }

        }
      },
      methods: {
        setMulti(multi) {
          this.setData({
            multi
          });
        },

        setOuterClass(className) {
          this.setData({
            outerClass: className
          });
        },

        checkedChange() {
          if (this.multi) {
            const checked = !this.checked;
            this.setData({
              checked
            });

            if (this.group) {
              this.group.checkedChange(checked, this);
            }
          } else {
            const checked = this.checked;
            if (checked) return;
            this.setData({
              checked: true
            });

            if (this.group) {
              this.group.checkedChange(checked, this);
            }
          }

          this.$emit('change', {
            detail: {
              value: this.value,
              checked: this.checked
            }
          });
        }

      }
    });
    /***/
  })
  /******/

});
import mpCell from "../cell/cell";
import mpCheckboxGroup from "../checkbox-group/checkbox-group";

export default {
  data() {
    return {
      color: "",
      disabled: "",
      checked: "",
      value: "",
      multi: false,
      label: "",
      extClass: "",
      outerClass: ""
    };
  },

  components: {
    mpCell,
    mpCheckboxGroup
  },
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
  25: (
  /***/
  function (module, exports, __webpack_require__) {
    "use strict";

    Component({
      options: {
        addGlobalClass: true,
        multipleSlots: true
      },
      properties: {
        multi: {
          type: Boolean,
          value: true
        },
        checked: {
          type: Boolean,
          value: false
        },
        value: {
          type: String,
          value: ''
        },
        label: {
          type: String,
          value: 'label'
        },
        extClass: {
          type: String,
          value: ''
        }
      },
      data: {},
      relations: {
        '../checkbox-group/checkbox-group': {
          type: 'ancestor',

          linked(target) {
            this.group = target;
          },

          unlinked() {
            this.group = null;
          }

        }
      },
      methods: {
        setMulti(multi) {
          this.setData({
            multi
          });
        },

        setOuterClass(className) {
          this.setData({
            outerClass: className
          });
        },

        checkedChange() {
          if (this.multi) {
            const checked = !this.checked;
            this.setData({
              checked
            });

            if (this.group) {
              this.group.checkedChange(checked, this);
            }
          } else {
            const checked = this.checked;
            if (checked) return;
            this.setData({
              checked: true
            });

            if (this.group) {
              this.group.checkedChange(checked, this);
            }
          }

          this.$emit('change', {
            detail: {
              value: this.value,
              checked: this.checked
            }
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
.weui-cell_radio .weui-check+.weui-icon-checked{color:transparent}.weui-check[checked]+.weui-icon-checked{color:var(--weui-BRAND);-webkit-mask-image:url(data:image/svg+xml,%3Csvg%20width%3D%2224%22%20height%3D%2224%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%3E%3Cpath%20d%3D%22M8.657%2018.435L3%2012.778l1.414-1.414%204.95%204.95L20.678%205l1.414%201.414-12.02%2012.021a1%201%200%2001-1.415%200z%22%20fill-rule%3D%22evenodd%22%2F%3E%3C%2Fsvg%3E);mask-image:url(data:image/svg+xml,%3Csvg%20width%3D%2224%22%20height%3D%2224%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%3E%3Cpath%20d%3D%22M8.657%2018.435L3%2012.778l1.414-1.414%204.95%204.95L20.678%205l1.414%201.414-12.02%2012.021a1%201%200%2001-1.415%200z%22%20fill-rule%3D%22evenodd%22%2F%3E%3C%2Fsvg%3E)}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwUHZ1LXJMJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLGdEQUFnRCxpQkFBaUIsQ0FBQyx3Q0FBd0MsdUJBQXVCLENBQUMsd1VBQXdVLENBQUMsZ1VBQWdVIiwiZmlsZSI6InRvLmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi53ZXVpLWNlbGxfcmFkaW8gLndldWktY2hlY2srLndldWktaWNvbi1jaGVja2Vke2NvbG9yOnRyYW5zcGFyZW50fS53ZXVpLWNoZWNrW2NoZWNrZWRdKy53ZXVpLWljb24tY2hlY2tlZHtjb2xvcjp2YXIoLS13ZXVpLUJSQU5EKTstd2Via2l0LW1hc2staW1hZ2U6dXJsKGRhdGE6aW1hZ2Uvc3ZnK3htbCwlM0NzdmclMjB3aWR0aCUzRCUyMjI0JTIyJTIwaGVpZ2h0JTNEJTIyMjQlMjIlMjB4bWxucyUzRCUyMmh0dHAlM0ElMkYlMkZ3d3cudzMub3JnJTJGMjAwMCUyRnN2ZyUyMiUzRSUzQ3BhdGglMjBkJTNEJTIyTTguNjU3JTIwMTguNDM1TDMlMjAxMi43NzhsMS40MTQtMS40MTQlMjA0Ljk1JTIwNC45NUwyMC42NzglMjA1bDEuNDE0JTIwMS40MTQtMTIuMDIlMjAxMi4wMjFhMSUyMDElMjAwJTIwMDEtMS40MTUlMjAweiUyMiUyMGZpbGwtcnVsZSUzRCUyMmV2ZW5vZGQlMjIlMkYlM0UlM0MlMkZzdmclM0UpO21hc2staW1hZ2U6dXJsKGRhdGE6aW1hZ2Uvc3ZnK3htbCwlM0NzdmclMjB3aWR0aCUzRCUyMjI0JTIyJTIwaGVpZ2h0JTNEJTIyMjQlMjIlMjB4bWxucyUzRCUyMmh0dHAlM0ElMkYlMkZ3d3cudzMub3JnJTJGMjAwMCUyRnN2ZyUyMiUzRSUzQ3BhdGglMjBkJTNEJTIyTTguNjU3JTIwMTguNDM1TDMlMjAxMi43NzhsMS40MTQtMS40MTQlMjA0Ljk1JTIwNC45NUwyMC42NzglMjA1bDEuNDE0JTIwMS40MTQtMTIuMDIlMjAxMi4wMjFhMSUyMDElMjAwJTIwMDEtMS40MTUlMjAweiUyMiUyMGZpbGwtcnVsZSUzRCUyMmV2ZW5vZGQlMjIlMkYlM0UlM0MlMkZzdmclM0UpfSJdfQ== */
</style>