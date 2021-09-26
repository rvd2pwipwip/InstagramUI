package com.hdesrosiers.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hdesrosiers.instagramui.ui.theme.IconWithText

// https://www.youtube.com/watch?v=Kw4_i4l5y4s&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=17

val socialNetworks = listOf(
  IconWithText(name = "YouTube", icon = R.drawable.youtube),
  IconWithText(name = "Q&A", icon = R.drawable.qa),
  IconWithText(name = "Discord", icon = R.drawable.discord),
  IconWithText(name = "Telegram", icon = R.drawable.telegram),
)
val tabs = listOf(
  IconWithText(name = "Posts", icon = R.drawable.ic_grid),
  IconWithText(name = "Reels", icon = R.drawable.ic_reels),
  IconWithText(name = "IGTV", icon = R.drawable.ic_igtv),
  IconWithText(name = "Profile", icon = R.drawable.profile),
)

@Composable
fun ProfileScreen() {
  var selectedTabIndex by remember { mutableStateOf(0) }
  Column(
    modifier = Modifier
      .fillMaxWidth()
  ) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .widthIn(max = 500.dp)
        .padding(horizontal = 20.dp)
    ) {
      TopBar(name = "titolitho_official", modifier = Modifier.padding(top = 30.dp))
      Spacer(modifier = Modifier.height(16.dp))
      ProfileSection()
      Spacer(modifier = Modifier.height(25.dp))
      ButtonSection()
      Spacer(modifier = Modifier.height(25.dp))
      SocialNetworks(networks = socialNetworks)
      Spacer(modifier = Modifier.height(25.dp))
    }
    PostTabView(
      tabs = tabs,
      onTabSelected = {
        selectedTabIndex = it
      }
    )
    Spacer(modifier = Modifier.height(10.dp))
    when (selectedTabIndex) {
      0 -> PostSection(
        posts = listOf(
          painterResource(id = R.drawable.kmm),
          painterResource(id = R.drawable.intermediate_dev),
          painterResource(id = R.drawable.master_logical_thinking),
          painterResource(id = R.drawable.bad_habits),
          painterResource(id = R.drawable.multiple_languages),
          painterResource(id = R.drawable.learn_coding_fast),
        ),
        modifier = Modifier.fillMaxWidth()
      )
    }
  }

  /*
  LazyColumn(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .widthIn(max = 500.dp)
      .fillMaxHeight(),
    contentPadding = PaddingValues(20.dp),
  ) {
    item { TopBar(name = "titolitho_official", modifier = Modifier.padding(top = 30.dp)) }
    item { Spacer(modifier = Modifier.height(16.dp)) }
    item { ProfileSection() }
    item { Spacer(modifier = Modifier.height(25.dp)) }
    item { ButtonSection() }
    item { Spacer(modifier = Modifier.height(25.dp)) }
    item { SocialNetworks(networks = socialNetworks) }
    item { Spacer(modifier = Modifier.height(25.dp)) }
    item { PostTabView(tabs = tabs, onTabSelected = { selectedTabIndex = it }) }
    item { Spacer(modifier = Modifier.height(10.dp)) }
    item {
      PostSection(
        posts = listOf(
          painterResource(id = R.drawable.kmm),
          painterResource(id = R.drawable.intermediate_dev),
          painterResource(id = R.drawable.master_logical_thinking),
          painterResource(id = R.drawable.bad_habits),
          painterResource(id = R.drawable.multiple_languages),
          painterResource(id = R.drawable.learn_coding_fast),
        ),
        modifier = Modifier.fillMaxWidth()
      )
    }
  }
  */

}

@Composable
fun TopBar(
  name: String,
  modifier: Modifier = Modifier
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = modifier
      .fillMaxWidth()
  ) {
    Row {
      Icon(
        painter = painterResource(id = R.drawable.ic_back_ios),
        contentDescription = "Back",
        modifier = Modifier.size(30.dp)
      )
      Spacer(modifier = Modifier.width(10.dp))
      Text(
        text = name,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        overflow = TextOverflow.Ellipsis,
      )
    }
    Row {
      Icon(
        imageVector = Icons.Outlined.Notifications,
        contentDescription = "Notifications",
        modifier = Modifier.size(30.dp)
      )
      Spacer(modifier = Modifier.width(20.dp))
      Icon(
        painter = painterResource(id = R.drawable.ic_more_vert),
        contentDescription = "Menu",
        modifier = Modifier.size(30.dp)
      )
    }
  }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxWidth()
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier.fillMaxWidth()
    ) {
      RoundImage(
        image = painterResource(id = R.drawable.tito),
        modifier = modifier
          .size(100.dp)
          .weight(3f)
      )
      Spacer(modifier = Modifier.width(30.dp))
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
//          .background(Color.Green)
          .weight(7f)
      ) {
        ProfileStat(stat = "601", label = "Posts")
        ProfileStat(stat = "99.8K", label = "Followers")
        ProfileStat(stat = "72", label = "Following")
      }
    }
    Spacer(modifier = Modifier.height(10.dp))
    ProfileDescription(
      displayName = "Programming Mentor",
      description = "10 years of coding experience \uD83D\uDCBB\n" +
              "Want me to make your app? Send me an email! ✉️\n" +
              "⬇️ Android tutorials? Subscribe to my YouTube channel! ⬇️",
      url = "https://youtube.com/c/PhilippLackner",
      followedBy = listOf("codinginflow", "miakhalifa"),
      otherCount = 17
    )
  }
}

@Composable
fun RoundImage(
  image: Painter,
  modifier: Modifier = Modifier
) {
  Image(
    painter = image,
    contentDescription = "Photo",
    modifier = modifier
      .aspectRatio(
        ratio = 1f,
        matchHeightConstraintsFirst = true
      )
      .border(
        width = 1.dp,
        color = Color.LightGray,
        shape = CircleShape
      )
      .padding(3.dp)
      .clip(shape = CircleShape)
  )
}

@Composable
fun ProfileStat(
  stat: String,
  label: String
) {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Text(
      text = stat,
      style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
    )
    Text(
      text = label,
      style = MaterialTheme.typography.caption
    )
  }
}

@Composable
fun ProfileDescription(
  displayName: String,
  description: String,
  url: String,
  followedBy: List<String>,
  otherCount: Int
) {
  val letterSpacing = 0.5.sp
  val lineHeight = 20.sp

  Column(
    modifier = Modifier
      .fillMaxWidth()
  ) {
    Text(
      text = displayName,
      fontWeight = FontWeight.Bold,
      letterSpacing = letterSpacing,
      lineHeight = lineHeight
    )
    Text(
      text = description,
      letterSpacing = letterSpacing,
      lineHeight = lineHeight
    )
    Text(
      text = url,
      color = Color(0xFF3D3D91),
      letterSpacing = letterSpacing,
      lineHeight = lineHeight
    )
    if (followedBy.isNotEmpty()) {
      Text(
        text = buildAnnotatedString {
          val boldStyle = SpanStyle(
            color = MaterialTheme.colors.onSurface,
            fontWeight = FontWeight.Bold
          )
          append(text = "Followed by")
//          pushStyle(style = boldStyle)
          followedBy.forEachIndexed { index, name ->
            pushStyle(boldStyle)
            append(name)
            pop()
            if (index < followedBy.size - 1) {
              append(", ")
            }
          }
          if (otherCount > 2)
            append(" and ")
          pushStyle(boldStyle)
          append("$otherCount others")
        },
        letterSpacing = letterSpacing,
        lineHeight = lineHeight
      )
    }
  }
}

@Composable
fun ButtonSection(
  modifier: Modifier = Modifier
) {
  val minWidth = 95.dp
  val height = 40.dp

  Row(
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = modifier
      .fillMaxWidth()
  ) {
    ActionButton(
      text = "Following",
      icon = Icons.Default.KeyboardArrowDown,
      modifier = modifier
        .defaultMinSize(
          minWidth = minWidth,
          minHeight = height
        )
        .height(height = height)
    )
    ActionButton(
      text = "Message",
      modifier = modifier
        .defaultMinSize(
          minWidth = minWidth,
          minHeight = height
        )
        .height(height = height)
    )
    ActionButton(
      text = "Email",
      modifier = modifier
        .defaultMinSize(
          minWidth = minWidth,
          minHeight = height
        )
        .height(height = height)
    )
    ActionButton(
      icon = Icons.Default.KeyboardArrowDown,
      modifier = modifier
        .size(height)
    )
  }
}

@Composable
fun ActionButton(
  modifier: Modifier = Modifier,
  text: String? = null,
  icon: ImageVector? = null
) {
  Row(
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier
      .border(
        width = 1.dp,
        color = Color.LightGray,
        shape = RoundedCornerShape(5.dp)
      )
      .padding(horizontal = 10.dp)
  ) {
    if (!text.isNullOrBlank()) {
      Text(
        text = text,
        style = MaterialTheme.typography.button.copy(letterSpacing = 0.5.sp)
      )
    }
    icon?.let {
      Icon(
        imageVector = icon,
        contentDescription = null,
        tint = MaterialTheme.colors.onSurface
      )
    }
  }
}

@Composable
fun SocialNetworks(
  networks: List<IconWithText>
) {
  LazyRow(
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier.fillMaxWidth()
  ) {
    items(networks.size) {
      SocialNetworkItem(
        name = networks[it].name,
        icon = painterResource(id = networks[it].icon)
      )
    }
  }
}

@Composable
fun SocialNetworkItem(
  name: String,
  icon: Painter,
  modifier: Modifier = Modifier
) {
  val iconSize = 75.dp

  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    RoundImage(
      image = icon,
      modifier = modifier.size(iconSize)
    )
    Text(
      text = name,
      style = MaterialTheme.typography.body2
    )
  }
}

@Composable
fun PostTabView(
  modifier: Modifier = Modifier,
  tabs: List<IconWithText>,
  onTabSelected: (selectedIndex: Int) -> Unit
) {
  var selectedTabIndex by remember { mutableStateOf(0) }
  val inactiveColor = Color(0xff777777)
  TabRow(
    selectedTabIndex = selectedTabIndex,
    backgroundColor = Color.Transparent,
    contentColor = MaterialTheme.colors.primary,
    modifier = modifier
  ) {
    tabs.forEachIndexed { index, tab ->
      Tab(
        selected = selectedTabIndex == index,
        selectedContentColor = Color.Transparent,
        unselectedContentColor = inactiveColor,
        onClick = {
          selectedTabIndex = index
          onTabSelected(index)
        }
      ) {
        Icon(
          painter = painterResource(id = tab.icon),
          contentDescription = tab.name,
          tint = if (selectedTabIndex == index) MaterialTheme.colors.primary else inactiveColor,
          modifier = Modifier
            .padding(10.dp)
            .size(20.dp)
        )
      }
    }
  }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
  posts: List<Painter>,
  modifier: Modifier = Modifier
) {
  LazyVerticalGrid(
    cells = GridCells.Fixed(3),
    modifier = modifier
      .scale(1.01f)
  ) {
    items(posts.size) {
      Image(
        painter = posts[it],
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .aspectRatio(1f)
          .border(
            width = 1.dp,
            color = Color.White
          )
      )
    }
  }
}



































