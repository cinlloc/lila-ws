package lila.ws

trait StringValue extends Any {
  def value: String
  override def toString = value
}
trait IntValue extends Any {
  def value: Int
  override def toString = value.toString
}

case class User(id: User.ID) extends AnyVal

object User {
  type ID = String
}

case class Game(id: Game.ID) extends AnyVal

object Game {
  type ID = String
}

object Simul {
  type ID = String
}

case class Simul(id: Simul.ID) extends AnyVal

object Tour {
  type ID = String
}

case class Tour(id: Tour.ID) extends AnyVal

object Chat {
  type ID = String
}

case class Chat(id: Chat.ID) extends AnyVal

case class Sri(value: String) extends AnyVal with StringValue

object Sri {
  type Str = String
  def random = Sri(util.Util.random string 12)
  def from(str: String): Option[Sri] =
    if (str contains ' ') None
    else Some(Sri(str))
}

case class Flag private (value: String) extends AnyVal with StringValue

object Flag {
  def make(value: String) = value match {
    case "simul" | "tournament" | "api" => Some(Flag(value))
    case _ => None
  }
  val api = Flag("api")
}

case class Path(value: String) extends AnyVal with StringValue

case class ChapterId(value: String) extends AnyVal with StringValue

case class JsonString(value: String) extends AnyVal with StringValue

case class SocketVersion(value: Int) extends AnyVal with IntValue with Ordered[SocketVersion] {
  def compare(other: SocketVersion) = Integer.compare(value, other.value)
}

case class IsTroll(value: Boolean) extends AnyVal

case class RoomId(value: String) extends AnyVal with StringValue
