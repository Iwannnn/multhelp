<template>
<view :class="'weui-tabbar ' + extClass">
  <!-- 选中的时候往 weui-tabbar__item 加 class:weui-bar__item_on -->
  <view v-for="(item, index) in list" :key="index" :data-index="index" @tap="tabChange" :class="'weui-tabbar__item ' + (index === current ? 'weui-bar__item_on' : '')">
    <view style="position: relative;display:inline-block;">
      <image :src="current === index ? item.selectedIconPath : item.iconPath" class="weui-tabbar__icon"></image>
      <mp-badge v-if="item.badge || item.dot" :content="item.badge" style="position: absolute;top:-2px;left:calc(100% - 3px)"></mp-badge>
    </view>
    <view class="weui-tabbar__label">{{item.text}}</view>
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

  return __webpack_require__(__webpack_require__.s = 16);
  /******/
})(
/************************************************************************/

/******/
{
  /***/
  16: (
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
        list: {
          type: Array,
          value: []
        },
        current: {
          type: Number,
          value: 0
        }
      },
      methods: {
        tabChange(e) {
          const {
            index
          } = e.currentTarget.dataset;

          if (index === this.current) {
            return;
          }

          this.setData({
            current: index
          });
          this.$emit('change', {
            detail: {
              index,
              item: this.list[index]
            }
          });
        }

      }
    });
    /***/
  })
  /******/

});
import mpBadge from "../badge/badge";

export default {
  data() {
    return {
      current: "",
      list: [],
      extClass: ""
    };
  },

  components: {
    mpBadge
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
  16: (
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
        list: {
          type: Array,
          value: []
        },
        current: {
          type: Number,
          value: 0
        }
      },
      methods: {
        tabChange(e) {
          const {
            index
          } = e.currentTarget.dataset;

          if (index === this.current) {
            return;
          }

          this.setData({
            current: index
          });
          this.$emit('change', {
            detail: {
              index,
              item: this.list[index]
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
page,[data-weui-theme='light']{--weui-BG-0:#ededed;--weui-BG-1:#f7f7f7;--weui-BG-2:#fff;--weui-BG-3:#f7f7f7;--weui-BG-4:#4c4c4c;--weui-BG-5:#fff;--weui-FG-0:rgba(0,0,0,0.9);--weui-FG-HALF:rgba(0,0,0,0.9);--weui-FG-1:rgba(0,0,0,0.5);--weui-FG-2:rgba(0,0,0,0.3);--weui-FG-3:rgba(0,0,0,0.1);--weui-RED:#fa5151;--weui-ORANGE:#fa9d3b;--weui-YELLOW:#ffc300;--weui-GREEN:#91d300;--weui-LIGHTGREEN:#95ec69;--weui-BRAND:#07c160;--weui-BLUE:#10aeff;--weui-INDIGO:#1485ee;--weui-PURPLE:#6467f0;--weui-WHITE:#fff;--weui-LINK:#576b95;--weui-TEXTGREEN:#06ae56;--weui-FG:black;--weui-BG:white;--weui-TAG-TEXT-ORANGE:#fa9d3b;--weui-TAG-BACKGROUND-ORANGE:rgba(250,157,59,0.1);--weui-TAG-TEXT-GREEN:#06ae56;--weui-TAG-BACKGROUND-GREEN:rgba(6,174,86,0.1);--weui-TAG-TEXT-BLUE:#10aeff;--weui-TAG-BACKGROUND-BLUE:rgba(16,174,255,0.1);--weui-TAG-TEXT-BLACK:rgba(0,0,0,0.5);--weui-TAG-BACKGROUND-BLACK:rgba(0,0,0,0.05)}[data-weui-theme='dark']{--weui-BG-0:#111111;--weui-BG-1:#1e1e1e;--weui-BG-2:#191919;--weui-BG-3:#202020;--weui-BG-4:#404040;--weui-BG-5:#2c2c2c;--weui-FG-0:rgba(255,255,255,0.8);--weui-FG-HALF:rgba(255,255,255,0.6);--weui-FG-1:rgba(255,255,255,0.5);--weui-FG-2:rgba(255,255,255,0.3);--weui-FG-3:rgba(255,255,255,0.05);--weui-RED:#fa5151;--weui-ORANGE:#c87d2f;--weui-YELLOW:#cc9c00;--weui-GREEN:#74a800;--weui-LIGHTGREEN:#3eb575;--weui-BRAND:#07c160;--weui-BLUE:#10aeff;--weui-INDIGO:#1196ff;--weui-PURPLE:#8183ff;--weui-WHITE:rgba(255,255,255,0.8);--weui-LINK:#7d90a9;--weui-TEXTGREEN:#259c5c;--weui-FG:white;--weui-BG:black;--weui-TAG-TEXT-ORANGE:rgba(250,157,59,0.6);--weui-TAG-BACKGROUND-ORANGE:rgba(250,157,59,0.1);--weui-TAG-TEXT-GREEN:rgba(6,174,86,0.6);--weui-TAG-BACKGROUND-GREEN:rgba(6,174,86,0.1);--weui-TAG-TEXT-BLUE:rgba(16,174,255,0.6);--weui-TAG-BACKGROUND-BLUE:rgba(16,174,255,0.1);--weui-TAG-TEXT-BLACK:rgba(255,255,255,0.5);--weui-TAG-BACKGROUND-BLACK:rgba(255,255,255,0.05)}page,[data-weui-theme='light']{--weui-BG-COLOR-ACTIVE:#ececec}[data-weui-theme='dark']{--weui-BG-COLOR-ACTIVE:#373737}page,[data-weui-theme='light']{--weui-BTN-DISABLED-FONT-COLOR:rgba(0,0,0,0.2)}[data-weui-theme='dark']{--weui-BTN-DISABLED-FONT-COLOR:rgba(255,255,255,0.2)}page,[data-weui-theme='light']{--weui-BTN-DEFAULT-BG:#f2f2f2}[data-weui-theme='dark']{--weui-BTN-DEFAULT-BG:rgba(255,255,255,0.08)}page,[data-weui-theme='light']{--weui-BTN-DEFAULT-COLOR:#06ae56}[data-weui-theme='dark']{--weui-BTN-DEFAULT-COLOR:rgba(255,255,255,0.8)}page,[data-weui-theme='light']{--weui-BTN-DEFAULT-ACTIVE-BG:#e6e6e6}[data-weui-theme='dark']{--weui-BTN-DEFAULT-ACTIVE-BG:rgba(255,255,255,0.126)}page,[data-weui-theme='light']{--weui-DIALOG-LINE-COLOR:rgba(0,0,0,0.1)}[data-weui-theme='dark']{--weui-DIALOG-LINE-COLOR:rgba(255,255,255,0.1)}@media only screen and (min-width:450px){.weui-tabbar{flex-direction:column;width:60px;height:100%}.weui-tabbar:before{left:unset;height:unset;content:" ";position:absolute;right:0;top:0;width:1px;bottom:0;border-right:1px solid var(--weui-FG-3);color:var(--weui-FG-3);transform-origin:100% 0;transform:scaleX(.5)}.weui-tabbar__item{flex:none}}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwVkFyd3JnJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLCtCQUErQixtQkFBbUIsQ0FBQyxtQkFBbUIsQ0FBQyxnQkFBZ0IsQ0FBQyxtQkFBbUIsQ0FBQyxtQkFBbUIsQ0FBQyxnQkFBZ0IsQ0FBQywyQkFBMkIsQ0FBQyw4QkFBOEIsQ0FBQywyQkFBMkIsQ0FBQywyQkFBMkIsQ0FBQywyQkFBMkIsQ0FBQyxrQkFBa0IsQ0FBQyxxQkFBcUIsQ0FBQyxxQkFBcUIsQ0FBQyxvQkFBb0IsQ0FBQyx5QkFBeUIsQ0FBQyxvQkFBb0IsQ0FBQyxtQkFBbUIsQ0FBQyxxQkFBcUIsQ0FBQyxxQkFBcUIsQ0FBQyxpQkFBaUIsQ0FBQyxtQkFBbUIsQ0FBQyx3QkFBd0IsQ0FBQyxlQUFlLENBQUMsZUFBZSxDQUFDLDhCQUE4QixDQUFDLGlEQUFpRCxDQUFDLDZCQUE2QixDQUFDLDhDQUE4QyxDQUFDLDRCQUE0QixDQUFDLCtDQUErQyxDQUFDLHFDQUFxQyxDQUFDLDRDQUE0QyxDQUFDLHlCQUF5QixtQkFBbUIsQ0FBQyxtQkFBbUIsQ0FBQyxtQkFBbUIsQ0FBQyxtQkFBbUIsQ0FBQyxtQkFBbUIsQ0FBQyxtQkFBbUIsQ0FBQyxpQ0FBaUMsQ0FBQyxvQ0FBb0MsQ0FBQyxpQ0FBaUMsQ0FBQyxpQ0FBaUMsQ0FBQyxrQ0FBa0MsQ0FBQyxrQkFBa0IsQ0FBQyxxQkFBcUIsQ0FBQyxxQkFBcUIsQ0FBQyxvQkFBb0IsQ0FBQyx5QkFBeUIsQ0FBQyxvQkFBb0IsQ0FBQyxtQkFBbUIsQ0FBQyxxQkFBcUIsQ0FBQyxxQkFBcUIsQ0FBQyxrQ0FBa0MsQ0FBQyxtQkFBbUIsQ0FBQyx3QkFBd0IsQ0FBQyxlQUFlLENBQUMsZUFBZSxDQUFDLDJDQUEyQyxDQUFDLGlEQUFpRCxDQUFDLHdDQUF3QyxDQUFDLDhDQUE4QyxDQUFDLHlDQUF5QyxDQUFDLCtDQUErQyxDQUFDLDJDQUEyQyxDQUFDLGtEQUFrRCxDQUFDLCtCQUErQiw4QkFBOEIsQ0FBQyx5QkFBeUIsOEJBQThCLENBQUMsK0JBQStCLDhDQUE4QyxDQUFDLHlCQUF5QixvREFBb0QsQ0FBQywrQkFBK0IsNkJBQTZCLENBQUMseUJBQXlCLDRDQUE0QyxDQUFDLCtCQUErQixnQ0FBZ0MsQ0FBQyx5QkFBeUIsOENBQThDLENBQUMsK0JBQStCLG9DQUFvQyxDQUFDLHlCQUF5QixvREFBb0QsQ0FBQywrQkFBK0Isd0NBQXdDLENBQUMseUJBQXlCLDhDQUE4QyxDQUFDLHlDQUF5QyxhQUFhLHFCQUFxQixDQUFDLFVBQVUsQ0FBQyxXQUFXLENBQUMsb0JBQW9CLFVBQVUsQ0FBQyxZQUFZLENBQUMsV0FBVyxDQUFDLGlCQUFpQixDQUFDLE9BQU8sQ0FBQyxLQUFLLENBQUMsU0FBUyxDQUFDLFFBQVEsQ0FBQyx1Q0FBdUMsQ0FBQyxzQkFBc0IsQ0FBQyx1QkFBdUIsQ0FBQyxvQkFBb0IsQ0FBQyxtQkFBbUIsU0FBUyxDQUFDIiwiZmlsZSI6InRvLmNzcyIsInNvdXJjZXNDb250ZW50IjpbInBhZ2UsW2RhdGEtd2V1aS10aGVtZT0nbGlnaHQnXXstLXdldWktQkctMDojZWRlZGVkOy0td2V1aS1CRy0xOiNmN2Y3Zjc7LS13ZXVpLUJHLTI6I2ZmZjstLXdldWktQkctMzojZjdmN2Y3Oy0td2V1aS1CRy00OiM0YzRjNGM7LS13ZXVpLUJHLTU6I2ZmZjstLXdldWktRkctMDpyZ2JhKDAsMCwwLDAuOSk7LS13ZXVpLUZHLUhBTEY6cmdiYSgwLDAsMCwwLjkpOy0td2V1aS1GRy0xOnJnYmEoMCwwLDAsMC41KTstLXdldWktRkctMjpyZ2JhKDAsMCwwLDAuMyk7LS13ZXVpLUZHLTM6cmdiYSgwLDAsMCwwLjEpOy0td2V1aS1SRUQ6I2ZhNTE1MTstLXdldWktT1JBTkdFOiNmYTlkM2I7LS13ZXVpLVlFTExPVzojZmZjMzAwOy0td2V1aS1HUkVFTjojOTFkMzAwOy0td2V1aS1MSUdIVEdSRUVOOiM5NWVjNjk7LS13ZXVpLUJSQU5EOiMwN2MxNjA7LS13ZXVpLUJMVUU6IzEwYWVmZjstLXdldWktSU5ESUdPOiMxNDg1ZWU7LS13ZXVpLVBVUlBMRTojNjQ2N2YwOy0td2V1aS1XSElURTojZmZmOy0td2V1aS1MSU5LOiM1NzZiOTU7LS13ZXVpLVRFWFRHUkVFTjojMDZhZTU2Oy0td2V1aS1GRzpibGFjazstLXdldWktQkc6d2hpdGU7LS13ZXVpLVRBRy1URVhULU9SQU5HRTojZmE5ZDNiOy0td2V1aS1UQUctQkFDS0dST1VORC1PUkFOR0U6cmdiYSgyNTAsMTU3LDU5LDAuMSk7LS13ZXVpLVRBRy1URVhULUdSRUVOOiMwNmFlNTY7LS13ZXVpLVRBRy1CQUNLR1JPVU5ELUdSRUVOOnJnYmEoNiwxNzQsODYsMC4xKTstLXdldWktVEFHLVRFWFQtQkxVRTojMTBhZWZmOy0td2V1aS1UQUctQkFDS0dST1VORC1CTFVFOnJnYmEoMTYsMTc0LDI1NSwwLjEpOy0td2V1aS1UQUctVEVYVC1CTEFDSzpyZ2JhKDAsMCwwLDAuNSk7LS13ZXVpLVRBRy1CQUNLR1JPVU5ELUJMQUNLOnJnYmEoMCwwLDAsMC4wNSl9W2RhdGEtd2V1aS10aGVtZT0nZGFyayddey0td2V1aS1CRy0wOiMxMTExMTE7LS13ZXVpLUJHLTE6IzFlMWUxZTstLXdldWktQkctMjojMTkxOTE5Oy0td2V1aS1CRy0zOiMyMDIwMjA7LS13ZXVpLUJHLTQ6IzQwNDA0MDstLXdldWktQkctNTojMmMyYzJjOy0td2V1aS1GRy0wOnJnYmEoMjU1LDI1NSwyNTUsMC44KTstLXdldWktRkctSEFMRjpyZ2JhKDI1NSwyNTUsMjU1LDAuNik7LS13ZXVpLUZHLTE6cmdiYSgyNTUsMjU1LDI1NSwwLjUpOy0td2V1aS1GRy0yOnJnYmEoMjU1LDI1NSwyNTUsMC4zKTstLXdldWktRkctMzpyZ2JhKDI1NSwyNTUsMjU1LDAuMDUpOy0td2V1aS1SRUQ6I2ZhNTE1MTstLXdldWktT1JBTkdFOiNjODdkMmY7LS13ZXVpLVlFTExPVzojY2M5YzAwOy0td2V1aS1HUkVFTjojNzRhODAwOy0td2V1aS1MSUdIVEdSRUVOOiMzZWI1NzU7LS13ZXVpLUJSQU5EOiMwN2MxNjA7LS13ZXVpLUJMVUU6IzEwYWVmZjstLXdldWktSU5ESUdPOiMxMTk2ZmY7LS13ZXVpLVBVUlBMRTojODE4M2ZmOy0td2V1aS1XSElURTpyZ2JhKDI1NSwyNTUsMjU1LDAuOCk7LS13ZXVpLUxJTks6IzdkOTBhOTstLXdldWktVEVYVEdSRUVOOiMyNTljNWM7LS13ZXVpLUZHOndoaXRlOy0td2V1aS1CRzpibGFjazstLXdldWktVEFHLVRFWFQtT1JBTkdFOnJnYmEoMjUwLDE1Nyw1OSwwLjYpOy0td2V1aS1UQUctQkFDS0dST1VORC1PUkFOR0U6cmdiYSgyNTAsMTU3LDU5LDAuMSk7LS13ZXVpLVRBRy1URVhULUdSRUVOOnJnYmEoNiwxNzQsODYsMC42KTstLXdldWktVEFHLUJBQ0tHUk9VTkQtR1JFRU46cmdiYSg2LDE3NCw4NiwwLjEpOy0td2V1aS1UQUctVEVYVC1CTFVFOnJnYmEoMTYsMTc0LDI1NSwwLjYpOy0td2V1aS1UQUctQkFDS0dST1VORC1CTFVFOnJnYmEoMTYsMTc0LDI1NSwwLjEpOy0td2V1aS1UQUctVEVYVC1CTEFDSzpyZ2JhKDI1NSwyNTUsMjU1LDAuNSk7LS13ZXVpLVRBRy1CQUNLR1JPVU5ELUJMQUNLOnJnYmEoMjU1LDI1NSwyNTUsMC4wNSl9cGFnZSxbZGF0YS13ZXVpLXRoZW1lPSdsaWdodCddey0td2V1aS1CRy1DT0xPUi1BQ1RJVkU6I2VjZWNlY31bZGF0YS13ZXVpLXRoZW1lPSdkYXJrJ117LS13ZXVpLUJHLUNPTE9SLUFDVElWRTojMzczNzM3fXBhZ2UsW2RhdGEtd2V1aS10aGVtZT0nbGlnaHQnXXstLXdldWktQlROLURJU0FCTEVELUZPTlQtQ09MT1I6cmdiYSgwLDAsMCwwLjIpfVtkYXRhLXdldWktdGhlbWU9J2RhcmsnXXstLXdldWktQlROLURJU0FCTEVELUZPTlQtQ09MT1I6cmdiYSgyNTUsMjU1LDI1NSwwLjIpfXBhZ2UsW2RhdGEtd2V1aS10aGVtZT0nbGlnaHQnXXstLXdldWktQlROLURFRkFVTFQtQkc6I2YyZjJmMn1bZGF0YS13ZXVpLXRoZW1lPSdkYXJrJ117LS13ZXVpLUJUTi1ERUZBVUxULUJHOnJnYmEoMjU1LDI1NSwyNTUsMC4wOCl9cGFnZSxbZGF0YS13ZXVpLXRoZW1lPSdsaWdodCddey0td2V1aS1CVE4tREVGQVVMVC1DT0xPUjojMDZhZTU2fVtkYXRhLXdldWktdGhlbWU9J2RhcmsnXXstLXdldWktQlROLURFRkFVTFQtQ09MT1I6cmdiYSgyNTUsMjU1LDI1NSwwLjgpfXBhZ2UsW2RhdGEtd2V1aS10aGVtZT0nbGlnaHQnXXstLXdldWktQlROLURFRkFVTFQtQUNUSVZFLUJHOiNlNmU2ZTZ9W2RhdGEtd2V1aS10aGVtZT0nZGFyayddey0td2V1aS1CVE4tREVGQVVMVC1BQ1RJVkUtQkc6cmdiYSgyNTUsMjU1LDI1NSwwLjEyNil9cGFnZSxbZGF0YS13ZXVpLXRoZW1lPSdsaWdodCddey0td2V1aS1ESUFMT0ctTElORS1DT0xPUjpyZ2JhKDAsMCwwLDAuMSl9W2RhdGEtd2V1aS10aGVtZT0nZGFyayddey0td2V1aS1ESUFMT0ctTElORS1DT0xPUjpyZ2JhKDI1NSwyNTUsMjU1LDAuMSl9QG1lZGlhIG9ubHkgc2NyZWVuIGFuZCAobWluLXdpZHRoOjQ1MHB4KXsud2V1aS10YWJiYXJ7ZmxleC1kaXJlY3Rpb246Y29sdW1uO3dpZHRoOjYwcHg7aGVpZ2h0OjEwMCV9LndldWktdGFiYmFyOmJlZm9yZXtsZWZ0OnVuc2V0O2hlaWdodDp1bnNldDtjb250ZW50OlwiIFwiO3Bvc2l0aW9uOmFic29sdXRlO3JpZ2h0OjA7dG9wOjA7d2lkdGg6MXB4O2JvdHRvbTowO2JvcmRlci1yaWdodDoxcHggc29saWQgdmFyKC0td2V1aS1GRy0zKTtjb2xvcjp2YXIoLS13ZXVpLUZHLTMpO3RyYW5zZm9ybS1vcmlnaW46MTAwJSAwO3RyYW5zZm9ybTpzY2FsZVgoLjUpfS53ZXVpLXRhYmJhcl9faXRlbXtmbGV4Om5vbmV9fSJdfQ== */
</style>