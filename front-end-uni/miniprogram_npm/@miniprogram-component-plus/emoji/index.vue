<template>
<!--components/emoji/emoji.wxml-->
<view class="weui-emoji_area" :style="'height: ' + height + 'px; background-color: ' + backgroundColor">
  <view :class="'weui-emotion_list ' + (hasSafeBottom ? 'weui-emoji_area__has-safe-bottom' : '')" :style="'padding-left: ' + padding + 'px; padding-right: ' + padding + 'px;'">
    <view :hidden="!showHistory || history.length === 0">
      <view class="weui-emotion_head">最近使用</view>
      <block v-for="(item, index) in history" :key="index">
        <view class="weui-emotion_item" :data-idx="item" @tap="insertEmoji" :style="'margin-right: ' + ((index + 1) % perLine ? extraPadding : 0) + 'px'">
          <view :class="'weui-icon_emotion ' + emotions[item].style" :style="'background-image: url(' + source + ');'"></view>
        </view>
      </block>
    </view>
    <!-- 图片32px，每个宽度40px -->
    <view class="weui-emotion_head" style="margin-top: 8px;">所有表情</view>
    <block v-for="(item, index) in emotions" :key="index">
      <view class="weui-emotion_item" :data-idx="index" @tap="insertEmoji" :style="'padding-right: ' + ((index + 1) % perLine ? extraPadding : 0) + 'px'">
        <view :class="'weui-icon_emotion ' + item.style" :style="'background-image: url(' + source + ');'"></view>
      </view>
    </block>
  </view>
  <!--操作-->
  <view class="weui-emoji__operation">
    <view class="weui-emoji__operation__delete" @tap="deleteEmoji" v-if="showDel">
      <image src="/static/miniprogram_npm/@miniprogram-component-plus/emoji/icon_emotion_del.png" class="weui-emotion_del_btn"></image>
    </view>
    <view class="weui-emoji__operation__send" @tap="send" v-if="showSend">发送</view>
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

  return __webpack_require__(__webpack_require__.s = 2);
  /******/
})(
/************************************************************************/

/******/
[(
/* 0 */

/***/
function (module, exports, __webpack_require__) {
  "use strict";

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.default = [{
    'id': 0,
    'cn': '[微笑]',
    'hk': '[微笑]',
    'us': '[Smile]',
    'code': '/::)',
    'web_code': '/微笑',
    'style': 'smiley_0'
  }, {
    'id': 1,
    'cn': '[撇嘴]',
    'hk': '[撇嘴]',
    'us': '[Grimace]',
    'code': '/::~',
    'web_code': '/撇嘴',
    'style': 'smiley_1'
  }, {
    'id': 2,
    'cn': '[色]',
    'hk': '[色]',
    'us': '[Drool]',
    'code': '/::B',
    'web_code': '/色',
    'style': 'smiley_2'
  }, {
    'id': 3,
    'cn': '[发呆]',
    'hk': '[發呆]',
    'us': '[Scowl]',
    'code': '/::|',
    'web_code': '/发呆',
    'style': 'smiley_3'
  }, {
    'id': 4,
    'cn': '[得意]',
    'hk': '[得意]',
    'us': '[CoolGuy]',
    'code': '/:8-)',
    'web_code': '/得意',
    'style': 'smiley_4'
  }, {
    'id': 5,
    'cn': '[流泪]',
    'hk': '[流淚]',
    'us': '[Sob]',
    'code': '/::<',
    'web_code': '/流泪',
    'style': 'smiley_5'
  }, {
    'id': 6,
    'cn': '[害羞]',
    'hk': '[害羞]',
    'us': '[Shy]',
    'code': '/::$',
    'web_code': '/害羞',
    'style': 'smiley_6'
  }, {
    'id': 7,
    'cn': '[闭嘴]',
    'hk': '[閉嘴]',
    'us': '[Silent]',
    'code': '/::X',
    'web_code': '/闭嘴',
    'style': 'smiley_7'
  }, {
    'id': 8,
    'cn': '[睡]',
    'hk': '[睡]',
    'us': '[Sleep]',
    'code': '/::Z',
    'web_code': '/睡',
    'style': 'smiley_8'
  }, {
    'id': 9,
    'cn': '[大哭]',
    'hk': '[大哭]',
    'us': '[Cry]',
    'code': '/::"(',
    'web_code': '/大哭',
    'style': 'smiley_9'
  }, {
    'id': 10,
    'cn': '[尴尬]',
    'hk': '[尷尬]',
    'us': '[Awkward]',
    'code': '/::-|',
    'web_code': '/尴尬',
    'style': 'smiley_10'
  }, {
    'id': 11,
    'cn': '[发怒]',
    'hk': '[發怒]',
    'us': '[Angry]',
    'code': '/::@',
    'web_code': '/发怒',
    'style': 'smiley_11'
  }, {
    'id': 12,
    'cn': '[调皮]',
    'hk': '[調皮]',
    'us': '[Tongue]',
    'code': '/::P',
    'web_code': '/调皮',
    'style': 'smiley_12'
  }, {
    'id': 13,
    'cn': '[呲牙]',
    'hk': '[呲牙]',
    'us': '[Grin]',
    'code': '/::D',
    'web_code': '/呲牙',
    'style': 'smiley_13'
  }, {
    'id': 14,
    'cn': '[惊讶]',
    'hk': '[驚訝]',
    'us': '[Surprise]',
    'code': '/::O',
    'web_code': '/惊讶',
    'style': 'smiley_14'
  }, {
    'id': 15,
    'cn': '[难过]',
    'hk': '[難過]',
    'us': '[Frown]',
    'code': '/::(',
    'web_code': '/难过',
    'style': 'smiley_15'
  }, {
    'id': 16,
    'cn': '[酷]',
    'hk': '[酷]',
    'us': '[Ruthless]',
    'code': '/::+',
    'web_code': '/酷',
    'style': 'smiley_16'
  }, {
    'id': 17,
    'cn': '[冷汗]',
    'hk': '[冷汗]',
    'us': '[Blush]',
    'code': '/:--b',
    'web_code': '/冷汗',
    'style': 'smiley_17'
  }, {
    'id': 18,
    'cn': '[抓狂]',
    'hk': '[抓狂]',
    'us': '[Scream]',
    'code': '/::Q',
    'web_code': '/抓狂',
    'style': 'smiley_18'
  }, {
    'id': 19,
    'cn': '[吐]',
    'hk': '[吐]',
    'us': '[Puke]',
    'code': '/::T',
    'web_code': '/吐',
    'style': 'smiley_19'
  }, {
    'id': 20,
    'cn': '[偷笑]',
    'hk': '[偷笑]',
    'us': '[Chuckle]',
    'code': '/:,@P',
    'web_code': '/偷笑',
    'style': 'smiley_20'
  }, {
    'id': 21,
    'cn': '[愉快]',
    'hk': '[愉快]',
    'us': '[Joyful]',
    'code': '/:,@-D',
    'web_code': '/可爱',
    'style': 'smiley_21'
  }, {
    'id': 22,
    'cn': '[白眼]',
    'hk': '[白眼]',
    'us': '[Slight]',
    'code': '/::d',
    'web_code': '/白眼',
    'style': 'smiley_22'
  }, {
    'id': 23,
    'cn': '[傲慢]',
    'hk': '[傲慢]',
    'us': '[Smug]',
    'code': '/:,@o',
    'web_code': '/傲慢',
    'style': 'smiley_23'
  }, {
    'id': 24,
    'cn': '[饥饿]',
    'hk': '[饑餓]',
    'us': '[Hungry]',
    'code': '/::g',
    'web_code': '/饥饿',
    'style': 'smiley_24'
  }, {
    'id': 25,
    'cn': '[困]',
    'hk': '[累]',
    'us': '[Drowsy]',
    'code': '/:|-)',
    'web_code': '/困',
    'style': 'smiley_25'
  }, {
    'id': 26,
    'cn': '[惊恐]',
    'hk': '[驚恐]',
    'us': '[Panic]',
    'code': '/::!',
    'web_code': '/惊恐',
    'style': 'smiley_26'
  }, {
    'id': 27,
    'cn': '[流汗]',
    'hk': '[流汗]',
    'us': '[Sweat]',
    'code': '/::L',
    'web_code': '/流汗',
    'style': 'smiley_27'
  }, {
    'id': 28,
    'cn': '[憨笑]',
    'hk': '[大笑]',
    'us': '[Laugh]',
    'code': '/::>',
    'web_code': '/憨笑',
    'style': 'smiley_28'
  }, {
    'id': 29,
    'cn': '[悠闲]',
    'hk': '[悠閑]',
    'us': '[Commando]',
    'code': '/::,@',
    'web_code': '/大兵',
    'style': 'smiley_29'
  }, {
    'id': 30,
    'cn': '[奋斗]',
    'hk': '[奮鬥]',
    'us': '[Determined]',
    'code': '/:,@f',
    'web_code': '/奋斗',
    'style': 'smiley_30'
  }, {
    'id': 31,
    'cn': '[咒骂]',
    'hk': '[咒罵]',
    'us': '[Scold]',
    'code': '/::-S',
    'web_code': '/咒骂',
    'style': 'smiley_31'
  }, {
    'id': 32,
    'cn': '[疑问]',
    'hk': '[疑問]',
    'us': '[Shocked]',
    'code': '/:?',
    'web_code': '/疑问',
    'style': 'smiley_32'
  }, {
    'id': 33,
    'cn': '[嘘]',
    'hk': '[噓]',
    'us': '[Shhh]',
    'code': '/:,@x',
    'web_code': '/嘘',
    'style': 'smiley_33'
  }, {
    'id': 34,
    'cn': '[晕]',
    'hk': '[暈]',
    'us': '[Dizzy]',
    'code': '/:,@@',
    'web_code': '/晕',
    'style': 'smiley_34'
  }, {
    'id': 35,
    'cn': '[疯了]',
    'hk': '[瘋了]',
    'us': '[Tormented]',
    'code': '/::8',
    'web_code': '/折磨',
    'style': 'smiley_35'
  }, {
    'id': 36,
    'cn': '[衰]',
    'hk': '[衰]',
    'us': '[Toasted]',
    'code': '/:,@!',
    'web_code': '/衰',
    'style': 'smiley_36'
  }, {
    'id': 37,
    'cn': '[骷髅]',
    'hk': '[骷髏頭]',
    'us': '[Skull]',
    'code': '/:!!!',
    'web_code': '/骷髅',
    'style': 'smiley_37'
  }, {
    'id': 38,
    'cn': '[敲打]',
    'hk': '[敲打]',
    'us': '[Hammer]',
    'code': '/:xx',
    'web_code': '/敲打',
    'style': 'smiley_38'
  }, {
    'id': 39,
    'cn': '[再见]',
    'hk': '[再見]',
    'us': '[Wave]',
    'code': '/:bye',
    'web_code': '/再见',
    'style': 'smiley_39'
  }, {
    'id': 40,
    'cn': '[擦汗]',
    'hk': '[擦汗]',
    'us': '[Speechless]',
    'code': '/:wipe',
    'web_code': '/擦汗',
    'style': 'smiley_40'
  }, {
    'id': 41,
    'cn': '[抠鼻]',
    'hk': '[摳鼻]',
    'us': '[NosePick]',
    'code': '/:dig',
    'web_code': '/抠鼻',
    'style': 'smiley_41'
  }, {
    'id': 42,
    'cn': '[鼓掌]',
    'hk': '[鼓掌]',
    'us': '[Clap]',
    'code': '/:handclap',
    'web_code': '/鼓掌',
    'style': 'smiley_42'
  }, {
    'id': 43,
    'cn': '[糗大了]',
    'hk': '[羞辱]',
    'us': '[Shame]',
    'code': '/:&-(',
    'web_code': '/糗大了',
    'style': 'smiley_43'
  }, {
    'id': 44,
    'cn': '[坏笑]',
    'hk': '[壞笑]',
    'us': '[Trick]',
    'code': '/:B-)',
    'web_code': '/坏笑',
    'style': 'smiley_44'
  }, {
    'id': 45,
    'cn': '[左哼哼]',
    'hk': '[左哼哼]',
    'us': '[Bah！L]',
    'code': '/:<@',
    'web_code': '/左哼哼',
    'style': 'smiley_45'
  }, {
    'id': 46,
    'cn': '[右哼哼]',
    'hk': '[右哼哼]',
    'us': '[Bah！R]',
    'code': '/:@>',
    'web_code': '/右哼哼',
    'style': 'smiley_46'
  }, {
    'id': 47,
    'cn': '[哈欠]',
    'hk': '[哈欠]',
    'us': '[Yawn]',
    'code': '/::-O',
    'web_code': '/哈欠',
    'style': 'smiley_47'
  }, {
    'id': 48,
    'cn': '[鄙视]',
    'hk': '[鄙視]',
    'us': '[Pooh-pooh]',
    'code': '/:>-|',
    'web_code': '/鄙视',
    'style': 'smiley_48'
  }, {
    'id': 49,
    'cn': '[委屈]',
    'hk': '[委屈]',
    'us': '[Shrunken]',
    'code': '/:P-(',
    'web_code': '/委屈',
    'style': 'smiley_49'
  }, {
    'id': 50,
    'cn': '[快哭了]',
    'hk': '[快哭了]',
    'us': '[TearingUp]',
    'code': '/::"|',
    'web_code': '/快哭了',
    'style': 'smiley_50'
  }, {
    'id': 51,
    'cn': '[阴险]',
    'hk': '[陰險]',
    'us': '[Sly]',
    'code': '/:X-)',
    'web_code': '/阴险',
    'style': 'smiley_51'
  }, {
    'id': 52,
    'cn': '[亲亲]',
    'hk': '[親親]',
    'us': '[Kiss]',
    'code': '/::*',
    'web_code': '/亲亲',
    'style': 'smiley_52'
  }, {
    'id': 53,
    'cn': '[吓]',
    'hk': '[嚇]',
    'us': '[Wrath]',
    'code': '/:@x',
    'web_code': '/吓',
    'style': 'smiley_53'
  }, {
    'id': 54,
    'cn': '[可怜]',
    'hk': '[可憐]',
    'us': '[Whimper]',
    'code': '/:8*',
    'web_code': '/可怜',
    'style': 'smiley_54'
  }, {
    'id': 55,
    'cn': '[菜刀]',
    'hk': '[菜刀]',
    'us': '[Cleaver]',
    'code': '/:pd',
    'web_code': '/菜刀',
    'style': 'smiley_55'
  }, {
    'id': 56,
    'cn': '[西瓜]',
    'hk': '[西瓜]',
    'us': '[Watermelon]',
    'code': '/:<W>',
    'web_code': '/西瓜',
    'style': 'smiley_56'
  }, {
    'id': 57,
    'cn': '[啤酒]',
    'hk': '[啤酒]',
    'us': '[Beer]',
    'code': '/:beer',
    'web_code': '/啤酒',
    'style': 'smiley_57'
  }, {
    'id': 58,
    'cn': '[篮球]',
    'hk': '[籃球]',
    'us': '[Basketball]',
    'code': '/:basketb',
    'web_code': '/篮球',
    'style': 'smiley_58'
  }, {
    'id': 59,
    'cn': '[乒乓]',
    'hk': '[乒乓]',
    'us': '[PingPong]',
    'code': '/:oo',
    'web_code': '/乒乓',
    'style': 'smiley_59'
  }, {
    'id': 60,
    'cn': '[咖啡]',
    'hk': '[咖啡]',
    'us': '[Coffee]',
    'code': '/:coffee',
    'web_code': '/咖啡',
    'style': 'smiley_60'
  }, {
    'id': 61,
    'cn': '[饭]',
    'hk': '[飯]',
    'us': '[Rice]',
    'code': '/:eat',
    'web_code': '/饭',
    'style': 'smiley_61'
  }, {
    'id': 62,
    'cn': '[猪头]',
    'hk': '[豬頭]',
    'us': '[Pig]',
    'code': '/:pig',
    'web_code': '/猪头',
    'style': 'smiley_62'
  }, {
    'id': 63,
    'cn': '[玫瑰]',
    'hk': '[玫瑰]',
    'us': '[Rose]',
    'code': '/:rose',
    'web_code': '/玫瑰',
    'style': 'smiley_63'
  }, {
    'id': 64,
    'cn': '[凋谢]',
    'hk': '[枯萎]',
    'us': '[Wilt]',
    'code': '/:fade',
    'web_code': '/凋谢',
    'style': 'smiley_64'
  }, {
    'id': 65,
    'cn': '[嘴唇]',
    'hk': '[嘴唇]',
    'us': '[Lips]',
    'code': '/:showlove',
    'web_code': '/示爱',
    'style': 'smiley_65'
  }, {
    'id': 66,
    'cn': '[爱心]',
    'hk': '[愛心]',
    'us': '[Heart]',
    'code': '/:heart',
    'web_code': '/爱心',
    'style': 'smiley_66'
  }, {
    'id': 67,
    'cn': '[心碎]',
    'hk': '[心碎]',
    'us': '[BrokenHeart]',
    'code': '/:break',
    'web_code': '/心碎',
    'style': 'smiley_67'
  }, {
    'id': 68,
    'cn': '[蛋糕]',
    'hk': '[蛋糕]',
    'us': '[Cake]',
    'code': '/:cake',
    'web_code': '/蛋糕',
    'style': 'smiley_68'
  }, {
    'id': 69,
    'cn': '[闪电]',
    'hk': '[閃電]',
    'us': '[Lightning]',
    'code': '/:li',
    'web_code': '/闪电',
    'style': 'smiley_69'
  }, {
    'id': 70,
    'cn': '[炸弹]',
    'hk': '[炸彈]',
    'us': '[Bomb]',
    'code': '/:bome',
    'web_code': '/炸弹',
    'style': 'smiley_70'
  }, {
    'id': 71,
    'cn': '[刀]',
    'hk': '[刀]',
    'us': '[Dagger]',
    'code': '/:kn',
    'web_code': '/刀',
    'style': 'smiley_71'
  }, {
    'id': 72,
    'cn': '[足球]',
    'hk': '[足球]',
    'us': '[Soccer]',
    'code': '/:footb',
    'web_code': '/足球',
    'style': 'smiley_72'
  }, {
    'id': 73,
    'cn': '[瓢虫]',
    'hk': '[甲蟲]',
    'us': '[Ladybug]',
    'code': '/:ladybug',
    'web_code': '/瓢虫',
    'style': 'smiley_73'
  }, {
    'id': 74,
    'cn': '[便便]',
    'hk': '[便便]',
    'us': '[Poop]',
    'code': '/:shit',
    'web_code': '/便便',
    'style': 'smiley_74'
  }, {
    'id': 75,
    'cn': '[月亮]',
    'hk': '[月亮]',
    'us': '[Moon]',
    'code': '/:moon',
    'web_code': '/月亮',
    'style': 'smiley_75'
  }, {
    'id': 76,
    'cn': '[太阳]',
    'hk': '[太陽]',
    'us': '[Sun]',
    'code': '/:sun',
    'web_code': '/太阳',
    'style': 'smiley_76'
  }, {
    'id': 77,
    'cn': '[礼物]',
    'hk': '[禮物]',
    'us': '[Gift]',
    'code': '/:gift',
    'web_code': '/礼物',
    'style': 'smiley_77'
  }, {
    'id': 78,
    'cn': '[拥抱]',
    'hk': '[擁抱]',
    'us': '[Hug]',
    'code': '/:hug',
    'web_code': '/拥抱',
    'style': 'smiley_78'
  }, {
    'id': 79,
    'cn': '[强]',
    'hk': '[強]',
    'us': '[ThumbsUp]',
    'code': '/:strong',
    'web_code': '/强',
    'style': 'smiley_79'
  }, {
    'id': 80,
    'cn': '[弱]',
    'hk': '[弱]',
    'us': '[ThumbsDown]',
    'code': '/:weak',
    'web_code': '/弱',
    'style': 'smiley_80'
  }, {
    'id': 81,
    'cn': '[握手]',
    'hk': '[握手]',
    'us': '[Shake]',
    'code': '/:share',
    'web_code': '/握手',
    'style': 'smiley_81'
  }, {
    'id': 82,
    'cn': '[胜利]',
    'hk': '[勝利]',
    'us': '[Peace]',
    'code': '/:v',
    'web_code': '/胜利',
    'style': 'smiley_82'
  }, {
    'id': 83,
    'cn': '[抱拳]',
    'hk': '[抱拳]',
    'us': '[Fight]',
    'code': '/:@)',
    'web_code': '/抱拳',
    'style': 'smiley_83'
  }, {
    'id': 84,
    'cn': '[勾引]',
    'hk': '[勾引]',
    'us': '[Beckon]',
    'code': '/:jj',
    'web_code': '/勾引',
    'style': 'smiley_84'
  }, {
    'id': 85,
    'cn': '[拳头]',
    'hk': '[拳頭]',
    'us': '[Fist]',
    'code': '/:@@',
    'web_code': '/拳头',
    'style': 'smiley_85'
  }, {
    'id': 86,
    'cn': '[差劲]',
    'hk': '[差勁]',
    'us': '[Pinky]',
    'code': '/:bad',
    'web_code': '/差劲',
    'style': 'smiley_86'
  }, {
    'id': 87,
    'cn': '[爱你]',
    'hk': '[愛你]',
    'us': '[RockOn]',
    'code': '/:lvu',
    'web_code': '/爱你',
    'style': 'smiley_87'
  }, {
    'id': 88,
    'cn': '[NO]',
    'hk': '[NO]',
    'us': '[Nuh-uh]',
    'code': '/:no',
    'web_code': '/NO',
    'style': 'smiley_88'
  }, {
    'id': 89,
    'cn': '[OK]',
    'hk': '[OK]',
    'us': '[OK]',
    'code': '/:ok',
    'web_code': '/OK',
    'style': 'smiley_89'
  }, {
    'id': 90,
    'cn': '[爱情]',
    'hk': '[愛情]',
    'us': '[InLove]',
    'code': '/:love',
    'web_code': '/爱情',
    'style': 'smiley_90'
  }, {
    'id': 91,
    'cn': '[飞吻]',
    'hk': '[飛吻]',
    'us': '[Blowkiss]',
    'code': '/:<L>',
    'web_code': '/飞吻',
    'style': 'smiley_91'
  }, {
    'id': 92,
    'cn': '[跳跳]',
    'hk': '[跳跳]',
    'us': '[Waddle]',
    'code': '/:jump',
    'web_code': '/跳跳',
    'style': 'smiley_92'
  }, {
    'id': 93,
    'cn': '[发抖]',
    'hk': '[發抖]',
    'us': '[Tremble]',
    'code': '/:shake',
    'web_code': '/发抖',
    'style': 'smiley_93'
  }, {
    'id': 94,
    'cn': '[怄火]',
    'hk': '[噴火]',
    'us': '[Aaagh!]',
    'code': '/:<O>',
    'web_code': '/怄火',
    'style': 'smiley_94'
  }, {
    'id': 95,
    'cn': '[转圈]',
    'hk': '[轉圈]',
    'us': '[Twirl]',
    'code': '/:circle',
    'web_code': '/转圈',
    'style': 'smiley_95'
  }, {
    'id': 96,
    'cn': '[磕头]',
    'hk': '[磕頭]',
    'us': '[Kotow]',
    'code': '/:kotow',
    'web_code': '/磕头',
    'style': 'smiley_96'
  }, {
    'id': 97,
    'cn': '[回头]',
    'hk': '[回頭]',
    'us': '[Dramatic]',
    'code': '/:turn',
    'web_code': '/回头',
    'style': 'smiley_97'
  }, {
    'id': 98,
    'cn': '[跳绳]',
    'hk': '[跳繩]',
    'us': '[JumpRope]',
    'code': '/:skip',
    'web_code': '/跳绳',
    'style': 'smiley_98'
  }, {
    'id': 99,
    'cn': '[投降]',
    'hk': '[投降]',
    'us': '[Surrender]',
    'code': '/:oY',
    'web_code': '/挥手',
    'style': 'smiley_99'
  }, {
    'id': 100,
    'cn': '[激动]',
    'hk': '[激動]',
    'us': '[Hooray]',
    'code': '/:#-0',
    'web_code': '/激动',
    'style': 'smiley_100'
  }, {
    'id': 101,
    'cn': '[乱舞]',
    'hk': '[亂舞]',
    'us': '[Meditate]',
    'code': '/:hiphot',
    'web_code': '/街舞',
    'style': 'smiley_101'
  }, {
    'id': 102,
    'cn': '[献吻]',
    'hk': '[獻吻]',
    'us': '[Smooch]',
    'code': '/:kiss',
    'web_code': '/献吻',
    'style': 'smiley_102'
  }, {
    'id': 103,
    'cn': '[左太极]',
    'hk': '[左太極]',
    'us': '[TaiChi L]',
    'code': '/:<&',
    'web_code': '/左太极',
    'style': 'smiley_103'
  }, {
    'id': 104,
    'cn': '[右太极]',
    'hk': '[右太極]',
    'us': '[TaiChi R]',
    'code': '/:&>',
    'web_code': '/右太极',
    'style': 'smiley_104'
  }, {
    'id': 204,
    'cn': '[嘿哈]',
    'hk': '[吼嘿]',
    'us': '[Hey]',
    'code': '',
    'web_code': '',
    'style': 'e2_04'
  }, {
    'id': 205,
    'cn': '[捂脸]',
    'hk': '[掩面]',
    'us': '[Facepalm]',
    'code': '',
    'web_code': '',
    'style': 'e2_05'
  }, {
    'id': 202,
    'cn': '[奸笑]',
    'hk': '[奸笑]',
    'us': '[Smirk]',
    'code': '',
    'web_code': '',
    'style': 'e2_02'
  }, {
    'id': 206,
    'cn': '[机智]',
    'hk': '[機智]',
    'us': '[Smart]',
    'code': '',
    'web_code': '',
    'style': 'e2_06'
  }, {
    'id': 212,
    'cn': '[皱眉]',
    'hk': '[皺眉]',
    'us': '[Moue]',
    'code': '',
    'web_code': '',
    'style': 'e2_12'
  }, {
    'id': 211,
    'cn': '[耶]',
    'hk': '[歐耶]',
    'us': '[Yeah!]',
    'code': '',
    'web_code': '',
    'style': 'e2_11'
  }, {
    'id': 207,
    'cn': '[茶]',
    'hk': '[茶]',
    'us': '[Tea]',
    'code': '',
    'web_code': '',
    'style': 'e2_07'
  }, {
    'id': 209,
    'cn': '[红包]',
    'hk': '[Packet]',
    'us': '[Packet]',
    'code': '',
    'web_code': '',
    'style': 'e2_09'
  }, {
    'id': 210,
    'cn': '[蜡烛]',
    'hk': '[蠟燭]',
    'us': '[Candle]',
    'code': '',
    'web_code': '',
    'style': 'e2_10'
  }, {
    'id': 215,
    'cn': '[福]',
    'hk': '[福]',
    'us': '[Blessing]',
    'code': '',
    'web_code': '',
    'style': 'e2_15'
  }, {
    'id': 214,
    'cn': '[鸡]',
    'hk': '[小雞]',
    'us': '[Chick]',
    'code': '',
    'web_code': '',
    'style': 'e2_14'
  }, {
    'id': 300,
    'cn': '[笑脸]',
    'emoji': '😄',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F604'
  }, {
    'id': 301,
    'cn': '[生病]',
    'emoji': '😷',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F637'
  }, {
    'id': 302,
    'cn': '[破涕为笑]',
    'emoji': '😂',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F602'
  }, {
    'id': 303,
    'cn': '[吐舌]',
    'emoji': '😝',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F61D'
  }, {
    'id': 304,
    'cn': '[脸红]',
    'emoji': '😳',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F633'
  }, {
    'id': 305,
    'cn': '[恐惧]',
    'emoji': '😱',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F631'
  }, {
    'id': 306,
    'cn': '[失望]',
    'emoji': '😔',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F614'
  }, {
    'id': 307,
    'cn': '[无语]',
    'emoji': '😒',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F612'
  }, {
    'id': 308,
    'cn': '[鬼魂]',
    'emoji': '👻',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F47B'
  }, {
    'id': 309,
    'cn': '[合十]',
    'emoji': '🙏',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F64F'
  }, {
    'id': 310,
    'cn': '[强壮]',
    'emoji': '💪',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F4AA'
  }, {
    'id': 311,
    'cn': '[庆祝]',
    'emoji': '🎉',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F389'
  }, {
    'id': 312,
    'cn': '[礼物]',
    'hk': '',
    'us': '',
    'code': "\",
    'web_code': '',
    'style': 'u1F381'
  }, {
    'id': 313,
    'cn': '[吃瓜]',
    'hk': '[]',
    'us': '[]',
    'code': '',
    'web_code': '',
    'style': 'smiley_313'
  }, {
    'id': 314,
    'cn': '[加油]',
    'hk': '[]',
    'us': '[]',
    'code': '',
    'web_code': '',
    'style': 'smiley_314'
  }, {
    'id': 315,
    'cn': '[汗]',
    'hk': '[]',
    'us': '[]',
    'code': '',
    'web_code': '',
    'style': 'smiley_315'
  }, {
    'id': 316,
    'cn': '[天啊]',
    'hk': '[]',
    'us': '[]',
    'code': '',
    'web_code': '',
    'style': 'smiley_316'
  }, {
    'id': 317,
    'cn': '[Emm]',
    'hk': '[]',
    'us': '[]',
    'code': '',
    'web_code': '',
    'style': 'smiley_317'
  }, {
    'id': 318,
    'cn': '[社会社会]',
    'hk': '[]',
    'us': '[]',
    'code': '',
    'web_code': '',
    'style': 'smiley_318'
  }, {
    'id': 319,
    'cn': '[旺柴]',
    'hk': '[]',
    'us': '[]',
    'code': '',
    'web_code': '',
    'style': 'smiley_319'
  }, {
    'id': 320,
    'cn': '[好的]',
    'hk': '[]',
    'us': '[]',
    'code': '',
    'web_code': '',
    'style': 'smiley_320'
  }, {
    'id': 321,
    'cn': '[打脸]',
    'hk': '[]',
    'us': '[]',
    'code': '',
    'web_code': '',
    'style': 'smiley_321'
  }, {
    'id': 322,
    'cn': '[哇]',
    'hk': '[]',
    'us': '[]',
    'code': '',
    'web_code': '',
    'style': 'smiley_322'
  }];
  /***/
}),, (
/* 1 */

/* 2 */

/***/
function (module, exports, __webpack_require__) {
  "use strict";

  Object.defineProperty(exports, "__esModule", {
    value: true
  });

  var emoji_data_1 = __webpack_require__(0);

  var emoji_panel_data_1 = __webpack_require__(3);

  var parser_1 = __webpack_require__(4);

  var EMOTION_SIZE = 40;
  var emotionMap = {};
  var emotionNames = [];
  emoji_data_1.default.forEach(function (item) {
    emotionMap[item.id] = item;
    emotionNames.push(item.cn);
  });
  var emotions = [];
  emoji_panel_data_1.default.forEach(function (id) {
    return emotions.push(emotionMap[id]);
  });
  Component({
    options: {
      styleIsolation: 'page-shared',
      addGlobalClass: true,
      pureDataPattern: /^_/
    },
    properties: {
      padding: {
        type: Number,
        default: 15
      },
      backgroundColor: {
        type: String,
        default: '#EDEDED'
      },
      showSend: {
        type: Boolean,
        default: true
      },
      showDel: {
        type: Boolean,
        default: true
      },
      showHistory: {
        type: Boolean,
        default: true
      },
      height: {
        type: Number,
        default: 300
      },
      source: {
        type: String,
        default: ''
      }
    },
    data: {
      history: [],
      emotions: emotions,
      extraPadding: 0,
      perLine: 0
    },
    lifetimes: {
      attached: function attached() {
        var padding = this.data.padding;
        var systemInfo = uni.getSystemInfoSync();
        var areaWidth = systemInfo.windowWidth;
        var perLine = Math.floor((areaWidth - padding * 2) / 45);
        var extraPadding = Math.floor((areaWidth - padding * 2 - perLine * EMOTION_SIZE) / (perLine - 1));
        this.setData({
          perLine: perLine,
          extraPadding: extraPadding,
          hasSafeBottom: systemInfo.model.indexOf('iPhone X') >= 0
        });
      }
    },
    methods: {
      getEmojiNames: function getEmojiNames() {
        return emotionNames;
      },
      parseEmoji: parser_1.parseEmoji,
      insertEmoji: function insertEmoji(evt) {
        var data = this;
        var idx = evt.currentTarget.dataset.idx;
        var emotionName = data.emotions[idx].cn;
        this.LRUCache(data.history, data.perLine, idx);
        this.setData({
          history: data.history
        });
        this.$emit('insertemoji', {
          detail: {
            emotionName: emotionName
          }
        });
      },
      deleteEmoji: function deleteEmoji() {
        this.$emit('delemoji');
      },
      send: function send() {
        this.$emit('send');
      },
      LRUCache: function LRUCache(arr, limit, data) {
        var idx = arr.indexOf(data);

        if (idx >= 0) {
          arr.splice(idx, 1);
          arr.unshift(data);
        } else if (arr.length < limit) {
          arr.push(data);
        } else if (arr.length === limit) {
          arr[limit - 1] = data;
        }
      }
    }
  });
  /***/
}), (
/* 3 */

/***/
function (module, exports, __webpack_require__) {
  "use strict";

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.default = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20, 21, 22, 23, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 36, 37, 38, 39, 40, 41, 42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 54, 55, 56, 57, 60, 62, 63, 64, 65, 66, 67, 68, 70, 74, 75, 76, 78, 79, 80, 81, 82, 83, 84, 85, 89, 92, 93, 94, 95, 300, 301, 302, 303, 304, 305, 306, 307, 204, 205, 202, 206, 212, 211, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 308, 309, 310, 311, 312, 209];
  /***/
}), (
/* 4 */

/***/
function (module, exports, __webpack_require__) {
  "use strict";

  Object.defineProperty(exports, "__esModule", {
    value: true
  });

  var emoji_data_1 = __webpack_require__(0);

  var emotionMap = {};
  emoji_data_1.default.forEach(function (item, index) {
    if (item.cn) {
      emotionMap[item.cn] = item;
    }

    if (item.code) emotionMap[item.code] = item;
    if (item.us) emotionMap[item.us] = item;
  });

  var parseEmoji = function parseEmoji(content) {
    var emojiIndexList = [];

    for (var k in emotionMap) {
      var idx = content.indexOf(k);

      while (idx >= 0) {
        emojiIndexList.push({
          idx: idx,
          code: k,
          type: 2
        });
        idx = content.indexOf(k, idx + k.length);
      }
    }

    emojiIndexList = emojiIndexList.sort(function (a, b) {
      return a.idx - b.idx;
    });
    var newContentList = [];
    var lastTextIndex = 0;
    emojiIndexList.forEach(function (item) {
      if (lastTextIndex !== item.idx) {
        newContentList.push({
          type: 1,
          content: content.substring(lastTextIndex, item.idx)
        });
      }

      if (item.type === 2) {
        newContentList.push({
          type: item.type,
          content: content.substr(item.idx, item.code.length),
          imageClass: emotionMap[item.code].style
        });
      } else {
        newContentList.push({
          type: item.type,
          content: item.code,
          imageClass: item.value
        });
      }

      lastTextIndex = item.idx + item.code.length;
    });
    var lastText = content.substring(lastTextIndex);

    if (lastText) {
      newContentList.push({
        type: 1,
        content: lastText
      });
    }

    return newContentList;
  };

  exports.parseEmoji = parseEmoji;
  /***/
}
/******/
)]);

export default {
  data() {
    return {
      history: [],
      emotions: emotions,
      extraPadding: 0,
      perLine: 0,
      hasSafeBottom: false
    };
  },

  components: {},
  props: {
    padding: {
      type: Number,
      default: 15
    },
    backgroundColor: {
      type: String,
      default: '#EDEDED'
    },
    showSend: {
      type: Boolean,
      default: true
    },
    showDel: {
      type: Boolean,
      default: true
    },
    showHistory: {
      type: Boolean,
      default: true
    },
    height: {
      type: Number,
      default: 300
    },
    source: {
      type: String,
      default: ''
    }
  },

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
  value: true,
  'id': 0,
  'cn': '[微笑]',
  'hk': '[微笑]',
  'us': '[Smile]',
  'code': '/::)',
  'web_code': '/微笑',
  'style': 'smiley_0',
  'id': 1,
  'cn': '[撇嘴]',
  'hk': '[撇嘴]',
  'us': '[Grimace]',
  'code': '/::~',
  'web_code': '/撇嘴',
  'style': 'smiley_1',
  'id': 2,
  'cn': '[色]',
  'hk': '[色]',
  'us': '[Drool]',
  'code': '/::B',
  'web_code': '/色',
  'style': 'smiley_2',
  'id': 3,
  'cn': '[发呆]',
  'hk': '[發呆]',
  'us': '[Scowl]',
  'code': '/::|',
  'web_code': '/发呆',
  'style': 'smiley_3',
  'id': 4,
  'cn': '[得意]',
  'hk': '[得意]',
  'us': '[CoolGuy]',
  'code': '/:8-)',
  'web_code': '/得意',
  'style': 'smiley_4',
  'id': 5,
  'cn': '[流泪]',
  'hk': '[流淚]',
  'us': '[Sob]',
  'code': '/::<',
  'web_code': '/流泪',
  'style': 'smiley_5',
  'id': 6,
  'cn': '[害羞]',
  'hk': '[害羞]',
  'us': '[Shy]',
  'code': '/::$',
  'web_code': '/害羞',
  'style': 'smiley_6',
  'id': 7,
  'cn': '[闭嘴]',
  'hk': '[閉嘴]',
  'us': '[Silent]',
  'code': '/::X',
  'web_code': '/闭嘴',
  'style': 'smiley_7',
  'id': 8,
  'cn': '[睡]',
  'hk': '[睡]',
  'us': '[Sleep]',
  'code': '/::Z',
  'web_code': '/睡',
  'style': 'smiley_8',
  'id': 9,
  'cn': '[大哭]',
  'hk': '[大哭]',
  'us': '[Cry]',
  'code': '/::"(',
  'web_code': '/大哭',
  'style': 'smiley_9',
  'id': 10,
  'cn': '[尴尬]',
  'hk': '[尷尬]',
  'us': '[Awkward]',
  'code': '/::-|',
  'web_code': '/尴尬',
  'style': 'smiley_10',
  'id': 11,
  'cn': '[发怒]',
  'hk': '[發怒]',
  'us': '[Angry]',
  'code': '/::@',
  'web_code': '/发怒',
  'style': 'smiley_11',
  'id': 12,
  'cn': '[调皮]',
  'hk': '[調皮]',
  'us': '[Tongue]',
  'code': '/::P',
  'web_code': '/调皮',
  'style': 'smiley_12',
  'id': 13,
  'cn': '[呲牙]',
  'hk': '[呲牙]',
  'us': '[Grin]',
  'code': '/::D',
  'web_code': '/呲牙',
  'style': 'smiley_13',
  'id': 14,
  'cn': '[惊讶]',
  'hk': '[驚訝]',
  'us': '[Surprise]',
  'code': '/::O',
  'web_code': '/惊讶',
  'style': 'smiley_14',
  'id': 15,
  'cn': '[难过]',
  'hk': '[難過]',
  'us': '[Frown]',
  'code': '/::(',
  'web_code': '/难过',
  'style': 'smiley_15',
  'id': 16,
  'cn': '[酷]',
  'hk': '[酷]',
  'us': '[Ruthless]',
  'code': '/::+',
  'web_code': '/酷',
  'style': 'smiley_16',
  'id': 17,
  'cn': '[冷汗]',
  'hk': '[冷汗]',
  'us': '[Blush]',
  'code': '/:--b',
  'web_code': '/冷汗',
  'style': 'smiley_17',
  'id': 18,
  'cn': '[抓狂]',
  'hk': '[抓狂]',
  'us': '[Scream]',
  'code': '/::Q',
  'web_code': '/抓狂',
  'style': 'smiley_18',
  'id': 19,
  'cn': '[吐]',
  'hk': '[吐]',
  'us': '[Puke]',
  'code': '/::T',
  'web_code': '/吐',
  'style': 'smiley_19',
  'id': 20,
  'cn': '[偷笑]',
  'hk': '[偷笑]',
  'us': '[Chuckle]',
  'code': '/:,@P',
  'web_code': '/偷笑',
  'style': 'smiley_20',
  'id': 21,
  'cn': '[愉快]',
  'hk': '[愉快]',
  'us': '[Joyful]',
  'code': '/:,@-D',
  'web_code': '/可爱',
  'style': 'smiley_21',
  'id': 22,
  'cn': '[白眼]',
  'hk': '[白眼]',
  'us': '[Slight]',
  'code': '/::d',
  'web_code': '/白眼',
  'style': 'smiley_22',
  'id': 23,
  'cn': '[傲慢]',
  'hk': '[傲慢]',
  'us': '[Smug]',
  'code': '/:,@o',
  'web_code': '/傲慢',
  'style': 'smiley_23',
  'id': 24,
  'cn': '[饥饿]',
  'hk': '[饑餓]',
  'us': '[Hungry]',
  'code': '/::g',
  'web_code': '/饥饿',
  'style': 'smiley_24',
  'id': 25,
  'cn': '[困]',
  'hk': '[累]',
  'us': '[Drowsy]',
  'code': '/:|-)',
  'web_code': '/困',
  'style': 'smiley_25',
  'id': 26,
  'cn': '[惊恐]',
  'hk': '[驚恐]',
  'us': '[Panic]',
  'code': '/::!',
  'web_code': '/惊恐',
  'style': 'smiley_26',
  'id': 27,
  'cn': '[流汗]',
  'hk': '[流汗]',
  'us': '[Sweat]',
  'code': '/::L',
  'web_code': '/流汗',
  'style': 'smiley_27',
  'id': 28,
  'cn': '[憨笑]',
  'hk': '[大笑]',
  'us': '[Laugh]',
  'code': '/::>',
  'web_code': '/憨笑',
  'style': 'smiley_28',
  'id': 29,
  'cn': '[悠闲]',
  'hk': '[悠閑]',
  'us': '[Commando]',
  'code': '/::,@',
  'web_code': '/大兵',
  'style': 'smiley_29',
  'id': 30,
  'cn': '[奋斗]',
  'hk': '[奮鬥]',
  'us': '[Determined]',
  'code': '/:,@f',
  'web_code': '/奋斗',
  'style': 'smiley_30',
  'id': 31,
  'cn': '[咒骂]',
  'hk': '[咒罵]',
  'us': '[Scold]',
  'code': '/::-S',
  'web_code': '/咒骂',
  'style': 'smiley_31',
  'id': 32,
  'cn': '[疑问]',
  'hk': '[疑問]',
  'us': '[Shocked]',
  'code': '/:?',
  'web_code': '/疑问',
  'style': 'smiley_32',
  'id': 33,
  'cn': '[嘘]',
  'hk': '[噓]',
  'us': '[Shhh]',
  'code': '/:,@x',
  'web_code': '/嘘',
  'style': 'smiley_33',
  'id': 34,
  'cn': '[晕]',
  'hk': '[暈]',
  'us': '[Dizzy]',
  'code': '/:,@@',
  'web_code': '/晕',
  'style': 'smiley_34',
  'id': 35,
  'cn': '[疯了]',
  'hk': '[瘋了]',
  'us': '[Tormented]',
  'code': '/::8',
  'web_code': '/折磨',
  'style': 'smiley_35',
  'id': 36,
  'cn': '[衰]',
  'hk': '[衰]',
  'us': '[Toasted]',
  'code': '/:,@!',
  'web_code': '/衰',
  'style': 'smiley_36',
  'id': 37,
  'cn': '[骷髅]',
  'hk': '[骷髏頭]',
  'us': '[Skull]',
  'code': '/:!!!',
  'web_code': '/骷髅',
  'style': 'smiley_37',
  'id': 38,
  'cn': '[敲打]',
  'hk': '[敲打]',
  'us': '[Hammer]',
  'code': '/:xx',
  'web_code': '/敲打',
  'style': 'smiley_38',
  'id': 39,
  'cn': '[再见]',
  'hk': '[再見]',
  'us': '[Wave]',
  'code': '/:bye',
  'web_code': '/再见',
  'style': 'smiley_39',
  'id': 40,
  'cn': '[擦汗]',
  'hk': '[擦汗]',
  'us': '[Speechless]',
  'code': '/:wipe',
  'web_code': '/擦汗',
  'style': 'smiley_40',
  'id': 41,
  'cn': '[抠鼻]',
  'hk': '[摳鼻]',
  'us': '[NosePick]',
  'code': '/:dig',
  'web_code': '/抠鼻',
  'style': 'smiley_41',
  'id': 42,
  'cn': '[鼓掌]',
  'hk': '[鼓掌]',
  'us': '[Clap]',
  'code': '/:handclap',
  'web_code': '/鼓掌',
  'style': 'smiley_42',
  'id': 43,
  'cn': '[糗大了]',
  'hk': '[羞辱]',
  'us': '[Shame]',
  'code': '/:&-(',
  'web_code': '/糗大了',
  'style': 'smiley_43',
  'id': 44,
  'cn': '[坏笑]',
  'hk': '[壞笑]',
  'us': '[Trick]',
  'code': '/:B-)',
  'web_code': '/坏笑',
  'style': 'smiley_44',
  'id': 45,
  'cn': '[左哼哼]',
  'hk': '[左哼哼]',
  'us': '[Bah！L]',
  'code': '/:<@',
  'web_code': '/左哼哼',
  'style': 'smiley_45',
  'id': 46,
  'cn': '[右哼哼]',
  'hk': '[右哼哼]',
  'us': '[Bah！R]',
  'code': '/:@>',
  'web_code': '/右哼哼',
  'style': 'smiley_46',
  'id': 47,
  'cn': '[哈欠]',
  'hk': '[哈欠]',
  'us': '[Yawn]',
  'code': '/::-O',
  'web_code': '/哈欠',
  'style': 'smiley_47',
  'id': 48,
  'cn': '[鄙视]',
  'hk': '[鄙視]',
  'us': '[Pooh-pooh]',
  'code': '/:>-|',
  'web_code': '/鄙视',
  'style': 'smiley_48',
  'id': 49,
  'cn': '[委屈]',
  'hk': '[委屈]',
  'us': '[Shrunken]',
  'code': '/:P-(',
  'web_code': '/委屈',
  'style': 'smiley_49',
  'id': 50,
  'cn': '[快哭了]',
  'hk': '[快哭了]',
  'us': '[TearingUp]',
  'code': '/::"|',
  'web_code': '/快哭了',
  'style': 'smiley_50',
  'id': 51,
  'cn': '[阴险]',
  'hk': '[陰險]',
  'us': '[Sly]',
  'code': '/:X-)',
  'web_code': '/阴险',
  'style': 'smiley_51',
  'id': 52,
  'cn': '[亲亲]',
  'hk': '[親親]',
  'us': '[Kiss]',
  'code': '/::*',
  'web_code': '/亲亲',
  'style': 'smiley_52',
  'id': 53,
  'cn': '[吓]',
  'hk': '[嚇]',
  'us': '[Wrath]',
  'code': '/:@x',
  'web_code': '/吓',
  'style': 'smiley_53',
  'id': 54,
  'cn': '[可怜]',
  'hk': '[可憐]',
  'us': '[Whimper]',
  'code': '/:8*',
  'web_code': '/可怜',
  'style': 'smiley_54',
  'id': 55,
  'cn': '[菜刀]',
  'hk': '[菜刀]',
  'us': '[Cleaver]',
  'code': '/:pd',
  'web_code': '/菜刀',
  'style': 'smiley_55',
  'id': 56,
  'cn': '[西瓜]',
  'hk': '[西瓜]',
  'us': '[Watermelon]',
  'code': '/:<W>',
  'web_code': '/西瓜',
  'style': 'smiley_56',
  'id': 57,
  'cn': '[啤酒]',
  'hk': '[啤酒]',
  'us': '[Beer]',
  'code': '/:beer',
  'web_code': '/啤酒',
  'style': 'smiley_57',
  'id': 58,
  'cn': '[篮球]',
  'hk': '[籃球]',
  'us': '[Basketball]',
  'code': '/:basketb',
  'web_code': '/篮球',
  'style': 'smiley_58',
  'id': 59,
  'cn': '[乒乓]',
  'hk': '[乒乓]',
  'us': '[PingPong]',
  'code': '/:oo',
  'web_code': '/乒乓',
  'style': 'smiley_59',
  'id': 60,
  'cn': '[咖啡]',
  'hk': '[咖啡]',
  'us': '[Coffee]',
  'code': '/:coffee',
  'web_code': '/咖啡',
  'style': 'smiley_60',
  'id': 61,
  'cn': '[饭]',
  'hk': '[飯]',
  'us': '[Rice]',
  'code': '/:eat',
  'web_code': '/饭',
  'style': 'smiley_61',
  'id': 62,
  'cn': '[猪头]',
  'hk': '[豬頭]',
  'us': '[Pig]',
  'code': '/:pig',
  'web_code': '/猪头',
  'style': 'smiley_62',
  'id': 63,
  'cn': '[玫瑰]',
  'hk': '[玫瑰]',
  'us': '[Rose]',
  'code': '/:rose',
  'web_code': '/玫瑰',
  'style': 'smiley_63',
  'id': 64,
  'cn': '[凋谢]',
  'hk': '[枯萎]',
  'us': '[Wilt]',
  'code': '/:fade',
  'web_code': '/凋谢',
  'style': 'smiley_64',
  'id': 65,
  'cn': '[嘴唇]',
  'hk': '[嘴唇]',
  'us': '[Lips]',
  'code': '/:showlove',
  'web_code': '/示爱',
  'style': 'smiley_65',
  'id': 66,
  'cn': '[爱心]',
  'hk': '[愛心]',
  'us': '[Heart]',
  'code': '/:heart',
  'web_code': '/爱心',
  'style': 'smiley_66',
  'id': 67,
  'cn': '[心碎]',
  'hk': '[心碎]',
  'us': '[BrokenHeart]',
  'code': '/:break',
  'web_code': '/心碎',
  'style': 'smiley_67',
  'id': 68,
  'cn': '[蛋糕]',
  'hk': '[蛋糕]',
  'us': '[Cake]',
  'code': '/:cake',
  'web_code': '/蛋糕',
  'style': 'smiley_68',
  'id': 69,
  'cn': '[闪电]',
  'hk': '[閃電]',
  'us': '[Lightning]',
  'code': '/:li',
  'web_code': '/闪电',
  'style': 'smiley_69',
  'id': 70,
  'cn': '[炸弹]',
  'hk': '[炸彈]',
  'us': '[Bomb]',
  'code': '/:bome',
  'web_code': '/炸弹',
  'style': 'smiley_70',
  'id': 71,
  'cn': '[刀]',
  'hk': '[刀]',
  'us': '[Dagger]',
  'code': '/:kn',
  'web_code': '/刀',
  'style': 'smiley_71',
  'id': 72,
  'cn': '[足球]',
  'hk': '[足球]',
  'us': '[Soccer]',
  'code': '/:footb',
  'web_code': '/足球',
  'style': 'smiley_72',
  'id': 73,
  'cn': '[瓢虫]',
  'hk': '[甲蟲]',
  'us': '[Ladybug]',
  'code': '/:ladybug',
  'web_code': '/瓢虫',
  'style': 'smiley_73',
  'id': 74,
  'cn': '[便便]',
  'hk': '[便便]',
  'us': '[Poop]',
  'code': '/:shit',
  'web_code': '/便便',
  'style': 'smiley_74',
  'id': 75,
  'cn': '[月亮]',
  'hk': '[月亮]',
  'us': '[Moon]',
  'code': '/:moon',
  'web_code': '/月亮',
  'style': 'smiley_75',
  'id': 76,
  'cn': '[太阳]',
  'hk': '[太陽]',
  'us': '[Sun]',
  'code': '/:sun',
  'web_code': '/太阳',
  'style': 'smiley_76',
  'id': 77,
  'cn': '[礼物]',
  'hk': '[禮物]',
  'us': '[Gift]',
  'code': '/:gift',
  'web_code': '/礼物',
  'style': 'smiley_77',
  'id': 78,
  'cn': '[拥抱]',
  'hk': '[擁抱]',
  'us': '[Hug]',
  'code': '/:hug',
  'web_code': '/拥抱',
  'style': 'smiley_78',
  'id': 79,
  'cn': '[强]',
  'hk': '[強]',
  'us': '[ThumbsUp]',
  'code': '/:strong',
  'web_code': '/强',
  'style': 'smiley_79',
  'id': 80,
  'cn': '[弱]',
  'hk': '[弱]',
  'us': '[ThumbsDown]',
  'code': '/:weak',
  'web_code': '/弱',
  'style': 'smiley_80',
  'id': 81,
  'cn': '[握手]',
  'hk': '[握手]',
  'us': '[Shake]',
  'code': '/:share',
  'web_code': '/握手',
  'style': 'smiley_81',
  'id': 82,
  'cn': '[胜利]',
  'hk': '[勝利]',
  'us': '[Peace]',
  'code': '/:v',
  'web_code': '/胜利',
  'style': 'smiley_82',
  'id': 83,
  'cn': '[抱拳]',
  'hk': '[抱拳]',
  'us': '[Fight]',
  'code': '/:@)',
  'web_code': '/抱拳',
  'style': 'smiley_83',
  'id': 84,
  'cn': '[勾引]',
  'hk': '[勾引]',
  'us': '[Beckon]',
  'code': '/:jj',
  'web_code': '/勾引',
  'style': 'smiley_84',
  'id': 85,
  'cn': '[拳头]',
  'hk': '[拳頭]',
  'us': '[Fist]',
  'code': '/:@@',
  'web_code': '/拳头',
  'style': 'smiley_85',
  'id': 86,
  'cn': '[差劲]',
  'hk': '[差勁]',
  'us': '[Pinky]',
  'code': '/:bad',
  'web_code': '/差劲',
  'style': 'smiley_86',
  'id': 87,
  'cn': '[爱你]',
  'hk': '[愛你]',
  'us': '[RockOn]',
  'code': '/:lvu',
  'web_code': '/爱你',
  'style': 'smiley_87',
  'id': 88,
  'cn': '[NO]',
  'hk': '[NO]',
  'us': '[Nuh-uh]',
  'code': '/:no',
  'web_code': '/NO',
  'style': 'smiley_88',
  'id': 89,
  'cn': '[OK]',
  'hk': '[OK]',
  'us': '[OK]',
  'code': '/:ok',
  'web_code': '/OK',
  'style': 'smiley_89',
  'id': 90,
  'cn': '[爱情]',
  'hk': '[愛情]',
  'us': '[InLove]',
  'code': '/:love',
  'web_code': '/爱情',
  'style': 'smiley_90',
  'id': 91,
  'cn': '[飞吻]',
  'hk': '[飛吻]',
  'us': '[Blowkiss]',
  'code': '/:<L>',
  'web_code': '/飞吻',
  'style': 'smiley_91',
  'id': 92,
  'cn': '[跳跳]',
  'hk': '[跳跳]',
  'us': '[Waddle]',
  'code': '/:jump',
  'web_code': '/跳跳',
  'style': 'smiley_92',
  'id': 93,
  'cn': '[发抖]',
  'hk': '[發抖]',
  'us': '[Tremble]',
  'code': '/:shake',
  'web_code': '/发抖',
  'style': 'smiley_93',
  'id': 94,
  'cn': '[怄火]',
  'hk': '[噴火]',
  'us': '[Aaagh!]',
  'code': '/:<O>',
  'web_code': '/怄火',
  'style': 'smiley_94',
  'id': 95,
  'cn': '[转圈]',
  'hk': '[轉圈]',
  'us': '[Twirl]',
  'code': '/:circle',
  'web_code': '/转圈',
  'style': 'smiley_95',
  'id': 96,
  'cn': '[磕头]',
  'hk': '[磕頭]',
  'us': '[Kotow]',
  'code': '/:kotow',
  'web_code': '/磕头',
  'style': 'smiley_96',
  'id': 97,
  'cn': '[回头]',
  'hk': '[回頭]',
  'us': '[Dramatic]',
  'code': '/:turn',
  'web_code': '/回头',
  'style': 'smiley_97',
  'id': 98,
  'cn': '[跳绳]',
  'hk': '[跳繩]',
  'us': '[JumpRope]',
  'code': '/:skip',
  'web_code': '/跳绳',
  'style': 'smiley_98',
  'id': 99,
  'cn': '[投降]',
  'hk': '[投降]',
  'us': '[Surrender]',
  'code': '/:oY',
  'web_code': '/挥手',
  'style': 'smiley_99',
  'id': 100,
  'cn': '[激动]',
  'hk': '[激動]',
  'us': '[Hooray]',
  'code': '/:#-0',
  'web_code': '/激动',
  'style': 'smiley_100',
  'id': 101,
  'cn': '[乱舞]',
  'hk': '[亂舞]',
  'us': '[Meditate]',
  'code': '/:hiphot',
  'web_code': '/街舞',
  'style': 'smiley_101',
  'id': 102,
  'cn': '[献吻]',
  'hk': '[獻吻]',
  'us': '[Smooch]',
  'code': '/:kiss',
  'web_code': '/献吻',
  'style': 'smiley_102',
  'id': 103,
  'cn': '[左太极]',
  'hk': '[左太極]',
  'us': '[TaiChi L]',
  'code': '/:<&',
  'web_code': '/左太极',
  'style': 'smiley_103',
  'id': 104,
  'cn': '[右太极]',
  'hk': '[右太極]',
  'us': '[TaiChi R]',
  'code': '/:&>',
  'web_code': '/右太极',
  'style': 'smiley_104',
  'id': 204,
  'cn': '[嘿哈]',
  'hk': '[吼嘿]',
  'us': '[Hey]',
  'code': '',
  'web_code': '',
  'style': 'e2_04',
  'id': 205,
  'cn': '[捂脸]',
  'hk': '[掩面]',
  'us': '[Facepalm]',
  'code': '',
  'web_code': '',
  'style': 'e2_05',
  'id': 202,
  'cn': '[奸笑]',
  'hk': '[奸笑]',
  'us': '[Smirk]',
  'code': '',
  'web_code': '',
  'style': 'e2_02',
  'id': 206,
  'cn': '[机智]',
  'hk': '[機智]',
  'us': '[Smart]',
  'code': '',
  'web_code': '',
  'style': 'e2_06',
  'id': 212,
  'cn': '[皱眉]',
  'hk': '[皺眉]',
  'us': '[Moue]',
  'code': '',
  'web_code': '',
  'style': 'e2_12',
  'id': 211,
  'cn': '[耶]',
  'hk': '[歐耶]',
  'us': '[Yeah!]',
  'code': '',
  'web_code': '',
  'style': 'e2_11',
  'id': 207,
  'cn': '[茶]',
  'hk': '[茶]',
  'us': '[Tea]',
  'code': '',
  'web_code': '',
  'style': 'e2_07',
  'id': 209,
  'cn': '[红包]',
  'hk': '[Packet]',
  'us': '[Packet]',
  'code': '',
  'web_code': '',
  'style': 'e2_09',
  'id': 210,
  'cn': '[蜡烛]',
  'hk': '[蠟燭]',
  'us': '[Candle]',
  'code': '',
  'web_code': '',
  'style': 'e2_10',
  'id': 215,
  'cn': '[福]',
  'hk': '[福]',
  'us': '[Blessing]',
  'code': '',
  'web_code': '',
  'style': 'e2_15',
  'id': 214,
  'cn': '[鸡]',
  'hk': '[小雞]',
  'us': '[Chick]',
  'code': '',
  'web_code': '',
  'style': 'e2_14',
  'id': 300,
  'cn': '[笑脸]',
  'emoji': '😄',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F604',
  'id': 301,
  'cn': '[生病]',
  'emoji': '😷',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F637',
  'id': 302,
  'cn': '[破涕为笑]',
  'emoji': '😂',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F602',
  'id': 303,
  'cn': '[吐舌]',
  'emoji': '😝',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F61D',
  'id': 304,
  'cn': '[脸红]',
  'emoji': '😳',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F633',
  'id': 305,
  'cn': '[恐惧]',
  'emoji': '😱',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F631',
  'id': 306,
  'cn': '[失望]',
  'emoji': '😔',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F614',
  'id': 307,
  'cn': '[无语]',
  'emoji': '😒',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F612',
  'id': 308,
  'cn': '[鬼魂]',
  'emoji': '👻',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F47B',
  'id': 309,
  'cn': '[合十]',
  'emoji': '🙏',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F64F',
  'id': 310,
  'cn': '[强壮]',
  'emoji': '💪',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F4AA',
  'id': 311,
  'cn': '[庆祝]',
  'emoji': '🎉',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F389',
  'id': 312,
  'cn': '[礼物]',
  'hk': '',
  'us': '',
  'code': "\",
  'web_code': '',
  'style': 'u1F381',
  'id': 313,
  'cn': '[吃瓜]',
  'hk': '[]',
  'us': '[]',
  'code': '',
  'web_code': '',
  'style': 'smiley_313',
  'id': 314,
  'cn': '[加油]',
  'hk': '[]',
  'us': '[]',
  'code': '',
  'web_code': '',
  'style': 'smiley_314',
  'id': 315,
  'cn': '[汗]',
  'hk': '[]',
  'us': '[]',
  'code': '',
  'web_code': '',
  'style': 'smiley_315',
  'id': 316,
  'cn': '[天啊]',
  'hk': '[]',
  'us': '[]',
  'code': '',
  'web_code': '',
  'style': 'smiley_316',
  'id': 317,
  'cn': '[Emm]',
  'hk': '[]',
  'us': '[]',
  'code': '',
  'web_code': '',
  'style': 'smiley_317',
  'id': 318,
  'cn': '[社会社会]',
  'hk': '[]',
  'us': '[]',
  'code': '',
  'web_code': '',
  'style': 'smiley_318',
  'id': 319,
  'cn': '[旺柴]',
  'hk': '[]',
  'us': '[]',
  'code': '',
  'web_code': '',
  'style': 'smiley_319',
  'id': 320,
  'cn': '[好的]',
  'hk': '[]',
  'us': '[]',
  'code': '',
  'web_code': '',
  'style': 'smiley_320',
  'id': 321,
  'cn': '[打脸]',
  'hk': '[]',
  'us': '[]',
  'code': '',
  'web_code': '',
  'style': 'smiley_321',
  'id': 322,
  'cn': '[哇]',
  'hk': '[]',
  'us': '[]',
  'code': '',
  'web_code': '',
  'style': 'smiley_322',
  value: true,
  options: {
    styleIsolation: 'page-shared',
    addGlobalClass: true,
    pureDataPattern: /^_/
  },
  beforeMount: function attached() {
    var padding = this.padding;
    var systemInfo = uni.getSystemInfoSync();
    var areaWidth = systemInfo.windowWidth;
    var perLine = Math.floor((areaWidth - padding * 2) / 45);
    var extraPadding = Math.floor((areaWidth - padding * 2 - perLine * EMOTION_SIZE) / (perLine - 1));
    this.setData({
      perLine: perLine,
      extraPadding: extraPadding,
      hasSafeBottom: systemInfo.model.indexOf('iPhone X') >= 0
    });
  },
  value: true,
  value: true,
  idx: idx,
  code: k,
  type: 2,
  type: 1,
  content: content.substring(lastTextIndex, item.idx),
  type: item.type,
  content: content.substr(item.idx, item.code.length),
  imageClass: emotionMap[item.code].style,
  type: item.type,
  content: item.code,
  imageClass: item.value,
  type: 1,
  content: lastText,
  methods: {
    getEmojiNames: function getEmojiNames() {
      return emotionNames;
    },
    parseEmoji: parser_1.parseEmoji,
    insertEmoji: function insertEmoji(evt) {
      var data = this;
      var idx = evt.currentTarget.dataset.idx;
      var emotionName = data.emotions[idx].cn;
      this.LRUCache(data.history, data.perLine, idx);
      this.setData({
        history: data.history
      });
      this.$emit('insertemoji', {
        detail: {
          emotionName: emotionName
        }
      });
    },
    deleteEmoji: function deleteEmoji() {
      this.$emit('delemoji');
    },
    send: function send() {
      this.$emit('send');
    },
    LRUCache: function LRUCache(arr, limit, data) {
      var idx = arr.indexOf(data);

      if (idx >= 0) {
        arr.splice(idx, 1);
        arr.unshift(data);
      } else if (arr.length < limit) {
        arr.push(data);
      } else if (arr.length === limit) {
        arr[limit - 1] = data;
      }
    }
  }
};
</script>
<style>
/*!-----The css code below is created by----*/.e2_02,.e2_04,.e2_05,.e2_06,.e2_09,.e2_11,.e2_12,.e2_14,.smiley_0,.smiley_1,.smiley_10,.smiley_11,.smiley_12,.smiley_13,.smiley_14,.smiley_15,.smiley_17,.smiley_18,.smiley_19,.smiley_2,.smiley_20,.smiley_21,.smiley_22,.smiley_23,.smiley_25,.smiley_26,.smiley_27,.smiley_28,.smiley_29,.smiley_3,.smiley_30,.smiley_31,.smiley_313,.smiley_314,.smiley_315,.smiley_316,.smiley_317,.smiley_318,.smiley_319,.smiley_32,.smiley_320,.smiley_321,.smiley_322,.smiley_33,.smiley_34,.smiley_36,.smiley_37,.smiley_38,.smiley_39,.smiley_4,.smiley_40,.smiley_41,.smiley_42,.smiley_44,.smiley_45,.smiley_46,.smiley_47,.smiley_48,.smiley_49,.smiley_5,.smiley_50,.smiley_51,.smiley_52,.smiley_54,.smiley_55,.smiley_56,.smiley_57,.smiley_6,.smiley_60,.smiley_61,.smiley_62,.smiley_63,.smiley_64,.smiley_65,.smiley_66,.smiley_67,.smiley_68,.smiley_7,.smiley_70,.smiley_74,.smiley_75,.smiley_76,.smiley_78,.smiley_79,.smiley_8,.smiley_80,.smiley_81,.smiley_82,.smiley_83,.smiley_84,.smiley_85,.smiley_89,.smiley_9,.smiley_92,.smiley_93,.smiley_94,.smiley_95,.u1F381,.u1F389,.u1F47B,.u1F4AA,.u1F602,.u1F604,.u1F612,.u1F614,.u1F61D,.u1F631,.u1F633,.u1F637,.u1F64F{display:inline-block;background-repeat:no-repeat}.e2_02{width:64px;height:64px;background-position:-66px 0}.e2_04{width:64px;height:64px;background-position:-462px -396px}.e2_05{width:64px;height:64px;background-position:0 -66px}.e2_06{width:64px;height:64px;background-position:-66px -66px}.e2_09{width:64px;height:64px;background-position:-132px 0}.e2_11{width:64px;height:64px;background-position:-132px -66px}.e2_12{width:64px;height:64px;background-position:0 -132px}.e2_14{width:64px;height:64px;background-position:-66px -132px}.smiley_0{width:64px;height:64px;background-position:-132px -132px}.smiley_1{width:63px;height:64px;background-position:-660px -594px}.smiley_10{width:64px;height:64px;background-position:-198px -66px}.smiley_11{width:64px;height:64px;background-position:-198px -132px}.smiley_12{width:64px;height:64px;background-position:0 -198px}.smiley_13{width:64px;height:64px;background-position:-66px -198px}.smiley_14{width:64px;height:64px;background-position:-132px -198px}.smiley_15{width:64px;height:64px;background-position:-198px -198px}.smiley_17{width:64px;height:64px;background-position:-264px 0}.smiley_18{width:64px;height:64px;background-position:-264px -66px}.smiley_19{width:64px;height:64px;background-position:-264px -132px}.smiley_2{width:64px;height:64px;background-position:-264px -198px}.smiley_20{width:64px;height:64px;background-position:0 -264px}.smiley_21{width:64px;height:64px;background-position:-66px -264px}.smiley_22{width:64px;height:64px;background-position:-132px -264px}.smiley_23{width:64px;height:64px;background-position:-198px -264px}.smiley_25{width:64px;height:64px;background-position:-264px -264px}.smiley_26{width:64px;height:64px;background-position:-330px 0}.smiley_27{width:64px;height:64px;background-position:-330px -66px}.smiley_28{width:64px;height:64px;background-position:-330px -132px}.smiley_29{width:64px;height:64px;background-position:-330px -198px}.smiley_3{width:64px;height:64px;background-position:-330px -264px}.smiley_30{width:64px;height:64px;background-position:0 -330px}.smiley_31{width:64px;height:64px;background-position:-66px -330px}.smiley_313{width:64px;height:64px;background-position:-132px -330px}.smiley_314{width:64px;height:64px;background-position:-198px -330px}.smiley_315{width:64px;height:64px;background-position:-264px -330px}.smiley_316{width:64px;height:64px;background-position:-330px -330px}.smiley_317{width:64px;height:64px;background-position:-396px 0}.smiley_318{width:64px;height:64px;background-position:-396px -66px}.smiley_319{width:64px;height:64px;background-position:-396px -132px}.smiley_32{width:64px;height:64px;background-position:-396px -198px}.smiley_320{width:64px;height:64px;background-position:-396px -264px}.smiley_321{width:64px;height:64px;background-position:-396px -330px}.smiley_322{width:64px;height:64px;background-position:0 -396px}.smiley_33{width:64px;height:64px;background-position:-66px -396px}.smiley_34{width:64px;height:64px;background-position:-132px -396px}.smiley_36{width:64px;height:64px;background-position:-198px -396px}.smiley_37{width:64px;height:64px;background-position:-264px -396px}.smiley_38{width:64px;height:64px;background-position:-330px -396px}.smiley_39{width:64px;height:64px;background-position:-396px -396px}.smiley_4{width:64px;height:64px;background-position:-462px 0}.smiley_40{width:64px;height:64px;background-position:-462px -66px}.smiley_41{width:64px;height:64px;background-position:-462px -132px}.smiley_42{width:64px;height:64px;background-position:-462px -198px}.smiley_44{width:64px;height:64px;background-position:-462px -264px}.smiley_45{width:64px;height:64px;background-position:-462px -330px}.smiley_46{width:64px;height:64px;background-position:0 0}.smiley_47{width:64px;height:64px;background-position:0 -462px}.smiley_48{width:64px;height:64px;background-position:-66px -462px}.smiley_49{width:64px;height:64px;background-position:-132px -462px}.smiley_5{width:64px;height:64px;background-position:-198px -462px}.smiley_50{width:64px;height:64px;background-position:-264px -462px}.smiley_51{width:64px;height:64px;background-position:-330px -462px}.smiley_52{width:64px;height:64px;background-position:-396px -462px}.smiley_54{width:64px;height:64px;background-position:-462px -462px}.smiley_55{width:64px;height:64px;background-position:-528px 0}.smiley_56{width:64px;height:64px;background-position:-528px -66px}.smiley_57{width:64px;height:64px;background-position:-528px -132px}.smiley_6{width:64px;height:64px;background-position:-528px -198px}.smiley_60{width:64px;height:64px;background-position:-528px -264px}.smiley_61{width:64px;height:64px;background-position:-528px -330px}.smiley_62{width:64px;height:64px;background-position:-528px -396px}.smiley_63{width:64px;height:64px;background-position:-528px -462px}.smiley_64{width:64px;height:64px;background-position:0 -528px}.smiley_65{width:64px;height:64px;background-position:-66px -528px}.smiley_66{width:64px;height:64px;background-position:-132px -528px}.smiley_67{width:64px;height:64px;background-position:-198px -528px}.smiley_68{width:64px;height:64px;background-position:-264px -528px}.smiley_7{width:64px;height:64px;background-position:-330px -528px}.smiley_70{width:64px;height:64px;background-position:-396px -528px}.smiley_74{width:64px;height:64px;background-position:-462px -528px}.smiley_75{width:64px;height:64px;background-position:-528px -528px}.smiley_76{width:64px;height:64px;background-position:-594px 0}.smiley_78{width:64px;height:64px;background-position:-594px -66px}.smiley_79{width:64px;height:64px;background-position:-594px -132px}.smiley_8{width:64px;height:64px;background-position:-594px -198px}.smiley_80{width:64px;height:64px;background-position:-594px -264px}.smiley_81{width:64px;height:64px;background-position:-594px -330px}.smiley_82{width:64px;height:64px;background-position:-594px -396px}.smiley_83{width:64px;height:64px;background-position:-594px -462px}.smiley_84{width:64px;height:64px;background-position:-594px -528px}.smiley_85{width:64px;height:64px;background-position:0 -594px}.smiley_89{width:64px;height:64px;background-position:-66px -594px}.smiley_9{width:64px;height:64px;background-position:-132px -594px}.smiley_92{width:64px;height:64px;background-position:-198px -594px}.smiley_93{width:64px;height:64px;background-position:-264px -594px}.smiley_94{width:64px;height:64px;background-position:-330px -594px}.smiley_95{width:64px;height:64px;background-position:-396px -594px}.u1F381{width:64px;height:64px;background-position:-462px -594px}.u1F389{width:64px;height:64px;background-position:-528px -594px}.u1F47B{width:64px;height:64px;background-position:-594px -594px}.u1F4AA{width:64px;height:64px;background-position:-660px 0}.u1F602{width:64px;height:64px;background-position:-660px -66px}.u1F604{width:64px;height:64px;background-position:-660px -132px}.u1F612{width:64px;height:64px;background-position:-660px -198px}.u1F614{width:64px;height:64px;background-position:-660px -264px}.u1F61D{width:64px;height:64px;background-position:-660px -330px}.u1F631{width:64px;height:64px;background-position:-660px -396px}.u1F633{width:64px;height:64px;background-position:-660px -462px}.u1F637{width:64px;height:64px;background-position:-198px 0}.u1F64F{width:64px;height:64px;background-position:-660px -528px}.weui-emotion_list{padding:0 10px;overflow-y:auto;-webkit-overflow-scrolling:touch;width:100%;height:100%;-webkit-box-sizing:border-box;box-sizing:border-box;white-space:normal;font-size:0}.weui-emotion_item{display:inline-block;position:relative;width:40px;height:40px;padding-bottom:5px;line-height:40px}.weui-icon_emotion{position:absolute;top:4px;left:4px;display:inline-block;transform-origin:0 0;transform:scale(.5)}.weui-emotion_head{margin:14px 5px 8px;color:#000;font-size:14px;text-align:left}.weui-emoji_area{position:relative;width:100%}.weui-emoji_area__has-safe-bottom{padding-bottom:34px}.weui-emotion_del_btn{display:inline-block;width:24px;height:24px;position:absolute;left:50%;top:50%;transform:translate(-50%, -50%)}.weui-emoji__operation{position:absolute;bottom:34px;right:12px;width:120px;height:44px;display:flex;align-items:center;justify-content:flex-end}.weui-emoji__operation__delete,.weui-emoji__operation__send{display:inline-block;width:56px;height:44px;line-height:44px;text-align:center;border-radius:4px;font-size:16px}.weui-emoji__operation__delete{position:relative;font-size:0;background-color:rgba(255, 255, 255)}.weui-emoji__operation__send{margin-left:8px;background-color:#04C160;color:rgba(255,255,255,0.9)}
/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIiUzQ2lucHV0JTIwY3NzJTIwX2JZb1NoJTNFIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLDZDQUE2QyxDQUFDLG1uQ0FBbW5DLG9CQUFvQixDQUFDLDJCQUEyQixDQUFDLE9BQU8sVUFBVSxDQUFDLFdBQVcsQ0FBQywyQkFBMkIsQ0FBQyxPQUFPLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsT0FBTyxVQUFVLENBQUMsV0FBVyxDQUFDLDJCQUEyQixDQUFDLE9BQU8sVUFBVSxDQUFDLFdBQVcsQ0FBQywrQkFBK0IsQ0FBQyxPQUFPLFVBQVUsQ0FBQyxXQUFXLENBQUMsNEJBQTRCLENBQUMsT0FBTyxVQUFVLENBQUMsV0FBVyxDQUFDLGdDQUFnQyxDQUFDLE9BQU8sVUFBVSxDQUFDLFdBQVcsQ0FBQyw0QkFBNEIsQ0FBQyxPQUFPLFVBQVUsQ0FBQyxXQUFXLENBQUMsZ0NBQWdDLENBQUMsVUFBVSxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFVBQVUsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsZ0NBQWdDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyw0QkFBNEIsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsZ0NBQWdDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsNEJBQTRCLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGdDQUFnQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxVQUFVLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLDRCQUE0QixDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxnQ0FBZ0MsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsNEJBQTRCLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGdDQUFnQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsVUFBVSxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyw0QkFBNEIsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsZ0NBQWdDLENBQUMsWUFBWSxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFlBQVksVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxZQUFZLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsWUFBWSxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFlBQVksVUFBVSxDQUFDLFdBQVcsQ0FBQyw0QkFBNEIsQ0FBQyxZQUFZLFVBQVUsQ0FBQyxXQUFXLENBQUMsZ0NBQWdDLENBQUMsWUFBWSxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxZQUFZLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsWUFBWSxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFlBQVksVUFBVSxDQUFDLFdBQVcsQ0FBQyw0QkFBNEIsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsZ0NBQWdDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxVQUFVLFVBQVUsQ0FBQyxXQUFXLENBQUMsNEJBQTRCLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGdDQUFnQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsdUJBQXVCLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLDRCQUE0QixDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxnQ0FBZ0MsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsVUFBVSxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsNEJBQTRCLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGdDQUFnQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxVQUFVLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyw0QkFBNEIsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsZ0NBQWdDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsVUFBVSxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyw0QkFBNEIsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsZ0NBQWdDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFVBQVUsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyw0QkFBNEIsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsZ0NBQWdDLENBQUMsVUFBVSxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxXQUFXLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsV0FBVyxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFdBQVcsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxRQUFRLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsUUFBUSxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFFBQVEsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxRQUFRLFVBQVUsQ0FBQyxXQUFXLENBQUMsNEJBQTRCLENBQUMsUUFBUSxVQUFVLENBQUMsV0FBVyxDQUFDLGdDQUFnQyxDQUFDLFFBQVEsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxRQUFRLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsUUFBUSxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFFBQVEsVUFBVSxDQUFDLFdBQVcsQ0FBQyxpQ0FBaUMsQ0FBQyxRQUFRLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsUUFBUSxVQUFVLENBQUMsV0FBVyxDQUFDLGlDQUFpQyxDQUFDLFFBQVEsVUFBVSxDQUFDLFdBQVcsQ0FBQyw0QkFBNEIsQ0FBQyxRQUFRLFVBQVUsQ0FBQyxXQUFXLENBQUMsaUNBQWlDLENBQUMsbUJBQW1CLGNBQWMsQ0FBQyxlQUFlLENBQUMsZ0NBQWdDLENBQUMsVUFBVSxDQUFDLFdBQVcsQ0FBQyw2QkFBNkIsQ0FBQyxxQkFBcUIsQ0FBQyxrQkFBa0IsQ0FBQyxXQUFXLENBQUMsbUJBQW1CLG9CQUFvQixDQUFDLGlCQUFpQixDQUFDLFVBQVUsQ0FBQyxXQUFXLENBQUMsa0JBQWtCLENBQUMsZ0JBQWdCLENBQUMsbUJBQW1CLGlCQUFpQixDQUFDLE9BQU8sQ0FBQyxRQUFRLENBQUMsb0JBQW9CLENBQUMsb0JBQW9CLENBQUMsbUJBQW1CLENBQUMsbUJBQW1CLG1CQUFtQixDQUFDLFVBQVUsQ0FBQyxjQUFjLENBQUMsZUFBZSxDQUFDLGlCQUFpQixpQkFBaUIsQ0FBQyxVQUFVLENBQUMsa0NBQWtDLG1CQUFtQixDQUFDLHNCQUFzQixvQkFBb0IsQ0FBQyxVQUFVLENBQUMsV0FBVyxDQUFDLGlCQUFpQixDQUFDLFFBQVEsQ0FBQyxPQUFPLENBQUMsK0JBQStCLENBQUMsdUJBQXVCLGlCQUFpQixDQUFDLFdBQVcsQ0FBQyxVQUFVLENBQUMsV0FBVyxDQUFDLFdBQVcsQ0FBQyxZQUFZLENBQUMsa0JBQWtCLENBQUMsd0JBQXdCLENBQUMsNERBQTRELG9CQUFvQixDQUFDLFVBQVUsQ0FBQyxXQUFXLENBQUMsZ0JBQWdCLENBQUMsaUJBQWlCLENBQUMsaUJBQWlCLENBQUMsY0FBYyxDQUFDLCtCQUErQixpQkFBaUIsQ0FBQyxXQUFXLENBQUMsb0NBQW9DLENBQUMsNkJBQTZCLGVBQWUsQ0FBQyx3QkFBd0IsQ0FBQywyQkFBMkIiLCJmaWxlIjoidG8uY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLyohLS0tLS1UaGUgY3NzIGNvZGUgYmVsb3cgaXMgY3JlYXRlZCBieS0tLS0qLy5lMl8wMiwuZTJfMDQsLmUyXzA1LC5lMl8wNiwuZTJfMDksLmUyXzExLC5lMl8xMiwuZTJfMTQsLnNtaWxleV8wLC5zbWlsZXlfMSwuc21pbGV5XzEwLC5zbWlsZXlfMTEsLnNtaWxleV8xMiwuc21pbGV5XzEzLC5zbWlsZXlfMTQsLnNtaWxleV8xNSwuc21pbGV5XzE3LC5zbWlsZXlfMTgsLnNtaWxleV8xOSwuc21pbGV5XzIsLnNtaWxleV8yMCwuc21pbGV5XzIxLC5zbWlsZXlfMjIsLnNtaWxleV8yMywuc21pbGV5XzI1LC5zbWlsZXlfMjYsLnNtaWxleV8yNywuc21pbGV5XzI4LC5zbWlsZXlfMjksLnNtaWxleV8zLC5zbWlsZXlfMzAsLnNtaWxleV8zMSwuc21pbGV5XzMxMywuc21pbGV5XzMxNCwuc21pbGV5XzMxNSwuc21pbGV5XzMxNiwuc21pbGV5XzMxNywuc21pbGV5XzMxOCwuc21pbGV5XzMxOSwuc21pbGV5XzMyLC5zbWlsZXlfMzIwLC5zbWlsZXlfMzIxLC5zbWlsZXlfMzIyLC5zbWlsZXlfMzMsLnNtaWxleV8zNCwuc21pbGV5XzM2LC5zbWlsZXlfMzcsLnNtaWxleV8zOCwuc21pbGV5XzM5LC5zbWlsZXlfNCwuc21pbGV5XzQwLC5zbWlsZXlfNDEsLnNtaWxleV80Miwuc21pbGV5XzQ0LC5zbWlsZXlfNDUsLnNtaWxleV80Niwuc21pbGV5XzQ3LC5zbWlsZXlfNDgsLnNtaWxleV80OSwuc21pbGV5XzUsLnNtaWxleV81MCwuc21pbGV5XzUxLC5zbWlsZXlfNTIsLnNtaWxleV81NCwuc21pbGV5XzU1LC5zbWlsZXlfNTYsLnNtaWxleV81Nywuc21pbGV5XzYsLnNtaWxleV82MCwuc21pbGV5XzYxLC5zbWlsZXlfNjIsLnNtaWxleV82Mywuc21pbGV5XzY0LC5zbWlsZXlfNjUsLnNtaWxleV82Niwuc21pbGV5XzY3LC5zbWlsZXlfNjgsLnNtaWxleV83LC5zbWlsZXlfNzAsLnNtaWxleV83NCwuc21pbGV5Xzc1LC5zbWlsZXlfNzYsLnNtaWxleV83OCwuc21pbGV5Xzc5LC5zbWlsZXlfOCwuc21pbGV5XzgwLC5zbWlsZXlfODEsLnNtaWxleV84Miwuc21pbGV5XzgzLC5zbWlsZXlfODQsLnNtaWxleV84NSwuc21pbGV5Xzg5LC5zbWlsZXlfOSwuc21pbGV5XzkyLC5zbWlsZXlfOTMsLnNtaWxleV85NCwuc21pbGV5Xzk1LC51MUYzODEsLnUxRjM4OSwudTFGNDdCLC51MUY0QUEsLnUxRjYwMiwudTFGNjA0LC51MUY2MTIsLnUxRjYxNCwudTFGNjFELC51MUY2MzEsLnUxRjYzMywudTFGNjM3LC51MUY2NEZ7ZGlzcGxheTppbmxpbmUtYmxvY2s7YmFja2dyb3VuZC1yZXBlYXQ6bm8tcmVwZWF0fS5lMl8wMnt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTY2cHggMH0uZTJfMDR7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi00NjJweCAtMzk2cHh9LmUyXzA1e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjowIC02NnB4fS5lMl8wNnt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTY2cHggLTY2cHh9LmUyXzA5e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMTMycHggMH0uZTJfMTF7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0xMzJweCAtNjZweH0uZTJfMTJ7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOjAgLTEzMnB4fS5lMl8xNHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTY2cHggLTEzMnB4fS5zbWlsZXlfMHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTEzMnB4IC0xMzJweH0uc21pbGV5XzF7d2lkdGg6NjNweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi02NjBweCAtNTk0cHh9LnNtaWxleV8xMHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTE5OHB4IC02NnB4fS5zbWlsZXlfMTF7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0xOThweCAtMTMycHh9LnNtaWxleV8xMnt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246MCAtMTk4cHh9LnNtaWxleV8xM3t3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTY2cHggLTE5OHB4fS5zbWlsZXlfMTR7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0xMzJweCAtMTk4cHh9LnNtaWxleV8xNXt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTE5OHB4IC0xOThweH0uc21pbGV5XzE3e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMjY0cHggMH0uc21pbGV5XzE4e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMjY0cHggLTY2cHh9LnNtaWxleV8xOXt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTI2NHB4IC0xMzJweH0uc21pbGV5XzJ7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0yNjRweCAtMTk4cHh9LnNtaWxleV8yMHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246MCAtMjY0cHh9LnNtaWxleV8yMXt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTY2cHggLTI2NHB4fS5zbWlsZXlfMjJ7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0xMzJweCAtMjY0cHh9LnNtaWxleV8yM3t3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTE5OHB4IC0yNjRweH0uc21pbGV5XzI1e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMjY0cHggLTI2NHB4fS5zbWlsZXlfMjZ7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0zMzBweCAwfS5zbWlsZXlfMjd7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0zMzBweCAtNjZweH0uc21pbGV5XzI4e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMzMwcHggLTEzMnB4fS5zbWlsZXlfMjl7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0zMzBweCAtMTk4cHh9LnNtaWxleV8ze3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMzMwcHggLTI2NHB4fS5zbWlsZXlfMzB7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOjAgLTMzMHB4fS5zbWlsZXlfMzF7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi02NnB4IC0zMzBweH0uc21pbGV5XzMxM3t3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTEzMnB4IC0zMzBweH0uc21pbGV5XzMxNHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTE5OHB4IC0zMzBweH0uc21pbGV5XzMxNXt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTI2NHB4IC0zMzBweH0uc21pbGV5XzMxNnt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTMzMHB4IC0zMzBweH0uc21pbGV5XzMxN3t3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTM5NnB4IDB9LnNtaWxleV8zMTh7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0zOTZweCAtNjZweH0uc21pbGV5XzMxOXt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTM5NnB4IC0xMzJweH0uc21pbGV5XzMye3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMzk2cHggLTE5OHB4fS5zbWlsZXlfMzIwe3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMzk2cHggLTI2NHB4fS5zbWlsZXlfMzIxe3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMzk2cHggLTMzMHB4fS5zbWlsZXlfMzIye3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjowIC0zOTZweH0uc21pbGV5XzMze3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNjZweCAtMzk2cHh9LnNtaWxleV8zNHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTEzMnB4IC0zOTZweH0uc21pbGV5XzM2e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMTk4cHggLTM5NnB4fS5zbWlsZXlfMzd7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0yNjRweCAtMzk2cHh9LnNtaWxleV8zOHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTMzMHB4IC0zOTZweH0uc21pbGV5XzM5e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMzk2cHggLTM5NnB4fS5zbWlsZXlfNHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTQ2MnB4IDB9LnNtaWxleV80MHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTQ2MnB4IC02NnB4fS5zbWlsZXlfNDF7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi00NjJweCAtMTMycHh9LnNtaWxleV80Mnt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTQ2MnB4IC0xOThweH0uc21pbGV5XzQ0e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNDYycHggLTI2NHB4fS5zbWlsZXlfNDV7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi00NjJweCAtMzMwcHh9LnNtaWxleV80Nnt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246MCAwfS5zbWlsZXlfNDd7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOjAgLTQ2MnB4fS5zbWlsZXlfNDh7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi02NnB4IC00NjJweH0uc21pbGV5XzQ5e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMTMycHggLTQ2MnB4fS5zbWlsZXlfNXt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTE5OHB4IC00NjJweH0uc21pbGV5XzUwe3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMjY0cHggLTQ2MnB4fS5zbWlsZXlfNTF7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0zMzBweCAtNDYycHh9LnNtaWxleV81Mnt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTM5NnB4IC00NjJweH0uc21pbGV5XzU0e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNDYycHggLTQ2MnB4fS5zbWlsZXlfNTV7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi01MjhweCAwfS5zbWlsZXlfNTZ7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi01MjhweCAtNjZweH0uc21pbGV5XzU3e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNTI4cHggLTEzMnB4fS5zbWlsZXlfNnt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTUyOHB4IC0xOThweH0uc21pbGV5XzYwe3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNTI4cHggLTI2NHB4fS5zbWlsZXlfNjF7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi01MjhweCAtMzMwcHh9LnNtaWxleV82Mnt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTUyOHB4IC0zOTZweH0uc21pbGV5XzYze3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNTI4cHggLTQ2MnB4fS5zbWlsZXlfNjR7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOjAgLTUyOHB4fS5zbWlsZXlfNjV7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi02NnB4IC01MjhweH0uc21pbGV5XzY2e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMTMycHggLTUyOHB4fS5zbWlsZXlfNjd7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0xOThweCAtNTI4cHh9LnNtaWxleV82OHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTI2NHB4IC01MjhweH0uc21pbGV5Xzd7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0zMzBweCAtNTI4cHh9LnNtaWxleV83MHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTM5NnB4IC01MjhweH0uc21pbGV5Xzc0e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNDYycHggLTUyOHB4fS5zbWlsZXlfNzV7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi01MjhweCAtNTI4cHh9LnNtaWxleV83Nnt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTU5NHB4IDB9LnNtaWxleV83OHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTU5NHB4IC02NnB4fS5zbWlsZXlfNzl7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi01OTRweCAtMTMycHh9LnNtaWxleV84e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNTk0cHggLTE5OHB4fS5zbWlsZXlfODB7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi01OTRweCAtMjY0cHh9LnNtaWxleV84MXt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTU5NHB4IC0zMzBweH0uc21pbGV5Xzgye3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNTk0cHggLTM5NnB4fS5zbWlsZXlfODN7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi01OTRweCAtNDYycHh9LnNtaWxleV84NHt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTU5NHB4IC01MjhweH0uc21pbGV5Xzg1e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjowIC01OTRweH0uc21pbGV5Xzg5e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNjZweCAtNTk0cHh9LnNtaWxleV85e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMTMycHggLTU5NHB4fS5zbWlsZXlfOTJ7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0xOThweCAtNTk0cHh9LnNtaWxleV85M3t3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTI2NHB4IC01OTRweH0uc21pbGV5Xzk0e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotMzMwcHggLTU5NHB4fS5zbWlsZXlfOTV7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0zOTZweCAtNTk0cHh9LnUxRjM4MXt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTQ2MnB4IC01OTRweH0udTFGMzg5e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNTI4cHggLTU5NHB4fS51MUY0N0J7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi01OTRweCAtNTk0cHh9LnUxRjRBQXt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTY2MHB4IDB9LnUxRjYwMnt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTY2MHB4IC02NnB4fS51MUY2MDR7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi02NjBweCAtMTMycHh9LnUxRjYxMnt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTY2MHB4IC0xOThweH0udTFGNjE0e3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNjYwcHggLTI2NHB4fS51MUY2MUR7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi02NjBweCAtMzMwcHh9LnUxRjYzMXt3aWR0aDo2NHB4O2hlaWdodDo2NHB4O2JhY2tncm91bmQtcG9zaXRpb246LTY2MHB4IC0zOTZweH0udTFGNjMze3dpZHRoOjY0cHg7aGVpZ2h0OjY0cHg7YmFja2dyb3VuZC1wb3NpdGlvbjotNjYwcHggLTQ2MnB4fS51MUY2Mzd7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi0xOThweCAwfS51MUY2NEZ7d2lkdGg6NjRweDtoZWlnaHQ6NjRweDtiYWNrZ3JvdW5kLXBvc2l0aW9uOi02NjBweCAtNTI4cHh9LndldWktZW1vdGlvbl9saXN0e3BhZGRpbmc6MCAxMHB4O292ZXJmbG93LXk6YXV0bzstd2Via2l0LW92ZXJmbG93LXNjcm9sbGluZzp0b3VjaDt3aWR0aDoxMDAlO2hlaWdodDoxMDAlOy13ZWJraXQtYm94LXNpemluZzpib3JkZXItYm94O2JveC1zaXppbmc6Ym9yZGVyLWJveDt3aGl0ZS1zcGFjZTpub3JtYWw7Zm9udC1zaXplOjB9LndldWktZW1vdGlvbl9pdGVte2Rpc3BsYXk6aW5saW5lLWJsb2NrO3Bvc2l0aW9uOnJlbGF0aXZlO3dpZHRoOjQwcHg7aGVpZ2h0OjQwcHg7cGFkZGluZy1ib3R0b206NXB4O2xpbmUtaGVpZ2h0OjQwcHh9LndldWktaWNvbl9lbW90aW9ue3Bvc2l0aW9uOmFic29sdXRlO3RvcDo0cHg7bGVmdDo0cHg7ZGlzcGxheTppbmxpbmUtYmxvY2s7dHJhbnNmb3JtLW9yaWdpbjowIDA7dHJhbnNmb3JtOnNjYWxlKC41KX0ud2V1aS1lbW90aW9uX2hlYWR7bWFyZ2luOjE0cHggNXB4IDhweDtjb2xvcjojMDAwO2ZvbnQtc2l6ZToxNHB4O3RleHQtYWxpZ246bGVmdH0ud2V1aS1lbW9qaV9hcmVhe3Bvc2l0aW9uOnJlbGF0aXZlO3dpZHRoOjEwMCV9LndldWktZW1vamlfYXJlYV9faGFzLXNhZmUtYm90dG9te3BhZGRpbmctYm90dG9tOjM0cHh9LndldWktZW1vdGlvbl9kZWxfYnRue2Rpc3BsYXk6aW5saW5lLWJsb2NrO3dpZHRoOjI0cHg7aGVpZ2h0OjI0cHg7cG9zaXRpb246YWJzb2x1dGU7bGVmdDo1MCU7dG9wOjUwJTt0cmFuc2Zvcm06dHJhbnNsYXRlKC01MCUsIC01MCUpfS53ZXVpLWVtb2ppX19vcGVyYXRpb257cG9zaXRpb246YWJzb2x1dGU7Ym90dG9tOjM0cHg7cmlnaHQ6MTJweDt3aWR0aDoxMjBweDtoZWlnaHQ6NDRweDtkaXNwbGF5OmZsZXg7YWxpZ24taXRlbXM6Y2VudGVyO2p1c3RpZnktY29udGVudDpmbGV4LWVuZH0ud2V1aS1lbW9qaV9fb3BlcmF0aW9uX19kZWxldGUsLndldWktZW1vamlfX29wZXJhdGlvbl9fc2VuZHtkaXNwbGF5OmlubGluZS1ibG9jazt3aWR0aDo1NnB4O2hlaWdodDo0NHB4O2xpbmUtaGVpZ2h0OjQ0cHg7dGV4dC1hbGlnbjpjZW50ZXI7Ym9yZGVyLXJhZGl1czo0cHg7Zm9udC1zaXplOjE2cHh9LndldWktZW1vamlfX29wZXJhdGlvbl9fZGVsZXRle3Bvc2l0aW9uOnJlbGF0aXZlO2ZvbnQtc2l6ZTowO2JhY2tncm91bmQtY29sb3I6cmdiYSgyNTUsIDI1NSwgMjU1KX0ud2V1aS1lbW9qaV9fb3BlcmF0aW9uX19zZW5ke21hcmdpbi1sZWZ0OjhweDtiYWNrZ3JvdW5kLWNvbG9yOiMwNEMxNjA7Y29sb3I6cmdiYSgyNTUsMjU1LDI1NSwwLjkpfSJdfQ== */
</style>